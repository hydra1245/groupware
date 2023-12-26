package com.kmc.groupware.service;

import com.kmc.groupware.domain.Notice;
import com.kmc.groupware.dto.NoticeDetailDto;
import com.kmc.groupware.dto.NoticeListDto;
import com.kmc.groupware.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository repository;

    public List<NoticeListDto> getList() {
        return repository.getList();
    }
    public void save(Notice notice) {
        repository.save(notice);
    }
    public long viewCountUpdate(long id) { return repository.viewCountUpdate(id);}
    public NoticeDetailDto getDetail(long id) {
        return repository.getDetail(id);
    }
    public long noticeDelete(long id) {
        return repository.noticeDelete(id);
    }
}
