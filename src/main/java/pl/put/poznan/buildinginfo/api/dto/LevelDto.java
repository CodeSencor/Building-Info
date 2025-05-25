package pl.put.poznan.buildinginfo.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import pl.put.poznan.buildinginfo.logic.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonPropertyOrder({"id", "name", "rooms"})
public class LevelDto {
    private final String id;
    private final String name;
    private final List<RoomDto> rooms;

    @JsonCreator
    public LevelDto(String id, String name, ArrayList<Room> rooms) {
        this.id = id;
        this.name = name;
        this.rooms = rooms.stream().map(room -> new RoomDto(room.getId(), room.getName(), room.getArea(), room.getCube(), room.getLight(), room.getHeating())).collect(Collectors.toList());
    }
}