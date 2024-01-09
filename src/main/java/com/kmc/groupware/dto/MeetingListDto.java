package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeetingListDto {
    private long id;
    private String placeName;
    private String meetingTitle;
    private String memberId;

    @QueryProjection
    public MeetingListDto(long id, String placeName, String meetingTitle, String memberId, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.placeName = placeName;
        this.meetingTitle = meetingTitle;
        this.memberId = memberId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
