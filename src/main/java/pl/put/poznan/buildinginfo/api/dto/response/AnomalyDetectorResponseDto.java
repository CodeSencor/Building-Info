package pl.put.poznan.buildinginfo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import pl.put.poznan.buildinginfo.api.dto.object.RoomDto;

import java.util.List;

@Getter
@JsonPropertyOrder({"id", "rooms"})
public class AnomalyDetectorResponseDto implements IResponseDto {
    private final String id;
    private final List<RoomDto> rooms;

    public AnomalyDetectorResponseDto(String id, List<RoomDto> rooms){
        this.id = id;
        this.rooms = rooms;
    }
}
