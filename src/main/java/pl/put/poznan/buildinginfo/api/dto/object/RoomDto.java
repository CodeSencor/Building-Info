package pl.put.poznan.buildinginfo.api.dto.object;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"id", "name", "area", "cube", "light", "heating"})
public class RoomDto implements ILocationDto{
    private final String id;
    private final String name;
    private final double area;
    private final double cube;
    private final double light;
    private final double heating;

    public RoomDto(String id, String name, double area, double cube, double light, double heating) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cube = cube;
        this.light = light;
        this.heating = heating;
    }
}