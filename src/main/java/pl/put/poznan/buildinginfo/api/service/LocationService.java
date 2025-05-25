package pl.put.poznan.buildinginfo.api.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.buildinginfo.api.dto.object.BuildingDto;
import pl.put.poznan.buildinginfo.api.dto.object.ILocationDto;
import pl.put.poznan.buildinginfo.api.dto.object.LevelDto;
import pl.put.poznan.buildinginfo.api.dto.object.RoomDto;
import pl.put.poznan.buildinginfo.api.dto.response.AnomalyDetectorResponseDto;
import pl.put.poznan.buildinginfo.api.dto.response.ErrorResponseDto;
import pl.put.poznan.buildinginfo.api.dto.response.IResponseDto;
import pl.put.poznan.buildinginfo.api.dto.response.VisitorDoubleResponseDto;
import pl.put.poznan.buildinginfo.logic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private ArrayList<ILocation> locationList;

    public LocationService() {
        this.locationList = new ArrayList<>();
        Room room = new Room("1", "room1", 1, 1, 1, 1);
        Room room2 = new Room("1b", "room2", 1.618, 1, 1, 1);
        locationList.add(room);
        locationList.add(room2);
        Level level = new Level("2", "level1", new ArrayList<>());
        locationList.add(level);
        level.addRoom(room);
        Building building = new Building("3", "building1", new ArrayList<>());
        locationList.add(building);
        building.addLevel(level);

    }

    private Optional<ILocation> getLocation(String id) {
        for (ILocation location : locationList) {
            if (Objects.equals(location.getId(), id)) {
                return Optional.of(location);
            }
        }
        return Optional.empty();
    }

    public Optional<ILocationDto> getLocationDto(String id){
        Optional<ILocation> location = this.getLocation(id);
        if(!location.isPresent()){
            return Optional.empty();
        }

        Class<? extends ILocation> locationClass = location.get().getClass();
        if(locationClass == Building.class){
            Building building = (Building) location.get();
            return Optional.of(new BuildingDto(building.getId(), building.getName(), building.getLevels()));
        } else if (locationClass == Level.class) {
            Level level = (Level) location.get();
            return Optional.of(new LevelDto(level.getId(), level.getName(), level.getRooms()));
        } else if (locationClass == Room.class) {
            Room room = (Room) location.get();
            return Optional.of(new RoomDto(room.getId(), room.getName(), room.getArea(), room.getCube(), room.getLight(), room.getHeating()));
        }

        return Optional.empty();
    }

    private IResponseDto useVisitor(String id, IVisitor visitor){
        Optional<ILocation> location = this.getLocation(id);
        if (location.isPresent()) {
            return new VisitorDoubleResponseDto(id, location.get().acceptVisitor(visitor));
        } else {
            return new ErrorResponseDto("Location not found.");
        }
    }

    public IResponseDto getArea(String id) {
        return useVisitor(id, new AreaVisitor());
    }

    public IResponseDto getCube(String id) {
        return useVisitor(id, new CubeVisitor());
    }

    public IResponseDto getLight(String id) {
        return useVisitor(id, new LightVisitor());
    }

    public IResponseDto getHeating(String id) {
        return useVisitor(id, new HeatingVisitor());
    }

    public IResponseDto getAnomalies(String id, double maxHeatCubeRatio) {
        Optional<ILocation> location = this.getLocation(id);
        if (!location.isPresent()) {
            return new ErrorResponseDto("Location not found.");
        }
        if (location.get().getClass() != Building.class) {
            return new ErrorResponseDto("Location is not a building.");
        }
        AnomalyDetector anomalyDetector = new AnomalyDetector();
        List<Room> anomalies = anomalyDetector.getAnomalies((Building) location.get(), maxHeatCubeRatio);
        return new AnomalyDetectorResponseDto(id, anomalies.stream().map(room -> new RoomDto(room.getId(), room.getName(), room.getArea(), room.getCube(), room.getLight(), room.getHeating())).collect(Collectors.toList()));
    }
}
