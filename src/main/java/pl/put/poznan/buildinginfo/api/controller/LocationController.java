package pl.put.poznan.buildinginfo.api.controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.api.dto.IRespondable;
import pl.put.poznan.buildinginfo.api.dto.object.ILocationDto;
import pl.put.poznan.buildinginfo.api.dto.response.ErrorResponseDto;
import pl.put.poznan.buildinginfo.api.dto.response.IResponseDto;
import pl.put.poznan.buildinginfo.api.service.LocationService;

import java.util.Optional;


@RequestMapping("/api")
@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/location/get")
    public IRespondable getLocation(@RequestParam String id){
        Optional<ILocationDto> location = locationService.getLocationDto(id);
        if(location.isPresent()){
            return location.get();
        }
        else{
            return new ErrorResponseDto("Location not found.");
        }
    }

    @GetMapping("/area")
    public IResponseDto getArea(@RequestParam String id){
        return locationService.getArea(id);
    }

    @GetMapping("/cube")
    public IResponseDto getCube(@RequestParam String id){
        return locationService.getCube(id);
    }

    @GetMapping("/light")
    public IResponseDto getLight(@RequestParam String id){
        return locationService.getLight(id);
    }

    @GetMapping("/heating")
    public IResponseDto getHeating(@RequestParam String id){
        return locationService.getHeating(id);
    }

    @GetMapping("/anomalies")
    public IResponseDto getAnomalies(@RequestParam String id, @RequestParam double maxHeatExceedRatio){
        return locationService.getAnomalies(id, maxHeatExceedRatio);
    }
}


