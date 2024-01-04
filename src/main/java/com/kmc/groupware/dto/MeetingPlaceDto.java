package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MeetingPlaceDto {

    @QueryProjection
    public MeetingPlaceDto(String placeName) {
        this.placeName = placeName;
    }

    public String placeName;


}
