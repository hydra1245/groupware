package com.kmc.groupware.repository;

import com.kmc.groupware.dto.MeetingListDto;

import java.util.List;

public interface MeetingReserveRepositoryCustom {
    long meetingReserveDelete(long id);
    List<MeetingListDto> getMeetingList(String startDate, String placeName);
}
