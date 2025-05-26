package pl.put.poznan.buildinginfo.api.dto.object;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import pl.put.poznan.buildinginfo.logic.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonPropertyOrder({"id", "name", "levels"})
public class BuildingDto implements ILocationDto {
    private final String id;
    private final String name;
    private final List<LevelDto> levels;

    public BuildingDto(String id, String name, ArrayList<Level> levels) {
        this.id = id;
        this.name = name;
        this.levels = levels.stream().map(level -> new LevelDto(level.getId(), level.getName(), level.getRooms())).collect(Collectors.toList());
    }

}
