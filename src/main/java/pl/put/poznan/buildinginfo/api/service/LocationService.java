package pl.put.poznan.buildinginfo.api.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.buildinginfo.api.model.ILocation;
import pl.put.poznan.buildinginfo.logic.Building;
import pl.put.poznan.buildinginfo.logic.Level;
import pl.put.poznan.buildinginfo.logic.Room;

import java.util.ArrayList;

@Service
public class LocationService {

    private ArrayList<ILocation> locationList;

    public Building getBuilding(){
        Room room = new Room("1", "room1", 1, 1, 1, 1);
        Level level = new Level("2", "level1", new ArrayList<>());
        level.addRoom(room);
        Building building = new Building("3", "building1", new ArrayList<>());
        building.addLevel(level);
        return building;
    }
}
