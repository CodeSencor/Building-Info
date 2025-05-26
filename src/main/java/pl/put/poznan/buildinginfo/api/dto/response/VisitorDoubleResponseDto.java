package pl.put.poznan.buildinginfo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder
public class VisitorDoubleResponseDto implements IResponseDto {
    private final String id;
    private final double value;

    public VisitorDoubleResponseDto(String id, double value){
        this.id = id;
        this.value = value;
    }
}
