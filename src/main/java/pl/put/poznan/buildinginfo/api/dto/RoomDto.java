package pl.put.poznan.buildinginfo.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"id", "name", "area", "cube", "light", "heating"})
public class RoomDto {
    private final String id;
    private final String name;
    private final double area;
    private final double cube;
    private final double light;
    private final double heating;

    @JsonCreator
    public RoomDto(String id, String name, double area, double cube, double light, double heating) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cube = cube;
        this.light = light;
        this.heating = heating;
    }
}