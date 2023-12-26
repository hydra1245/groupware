package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberRegistPlaceDto {
    private String PlaceName;

    @QueryProjection
    public MemberRegistPlaceDto(String placeName) {
        PlaceName = placeName;
    }
}
