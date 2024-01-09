package com.kmc.groupware.service;

import com.kmc.groupware.domain.MeetingReserve;
import com.kmc.groupware.dto.MeetingListDto;
import com.kmc.groupware.repository.MeetingReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingReserveService {
    private final MeetingReserveRepository repository;

    public long meetingDelete(long id) {
        return repository.meetingReserveDelete(id);
    }
    public Optional<MeetingReserve> findById(long id) {
        return repository.findById(id);
    }
    public List<MeetingListDto> getMeetingList(String startDate, String placeName) {
        return repository.getMeetingList(startDate, placeName);
    }
}
