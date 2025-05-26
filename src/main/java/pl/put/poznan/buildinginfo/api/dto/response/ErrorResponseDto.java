package pl.put.poznan.buildinginfo.api.dto.response;

import lombok.Getter;

@Getter
public class ErrorResponseDto implements IResponseDto {
    private final String error;

    public ErrorResponseDto(String error){
        this.error = error;
    }
}
