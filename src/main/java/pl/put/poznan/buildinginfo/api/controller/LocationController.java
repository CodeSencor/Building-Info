package pl.put.poznan.buildinginfo.api.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.api.dto.BuildingDto;
import pl.put.poznan.buildinginfo.api.service.LocationService;
import pl.put.poznan.buildinginfo.logic.Building;


@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping(value = "/g")
    public BuildingDto getBuilding(){
        Building building = locationService.getBuilding();
        return new BuildingDto(building.getId(), building.getName(), building.getLevels());
    }
}


