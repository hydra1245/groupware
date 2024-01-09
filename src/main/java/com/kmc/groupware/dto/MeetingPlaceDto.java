package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MeetingPlaceDto {

    @QueryProjection
    public MeetingPlaceDto(long id, String placeName) {
        this.id = id;
        this.placeName = placeName;
    }
    public long id;
    public String placeName;


}
