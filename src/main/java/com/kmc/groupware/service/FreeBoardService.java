package com.kmc.groupware.service;

import com.kmc.groupware.domain.FreeBoard;
import com.kmc.groupware.domain.Notice;
import com.kmc.groupware.dto.FreeBoardDetailDto;
import com.kmc.groupware.dto.FreeBoardListDto;
import com.kmc.groupware.dto.NoticeDetailDto;
import com.kmc.groupware.dto.NoticeListDto;
import com.kmc.groupware.repository.FreeBoardRepository;
import com.kmc.groupware.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {
    private final FreeBoardRepository repository;

    public List<FreeBoardListDto> getList() {
        return repository.getList();
    }
    public void save(FreeBoard board) {
        repository.save(board);
    }
    public long viewCountUpdate(long id) { return repository.viewCountUpdate(id);}
    public FreeBoardDetailDto getDetail(long id) {
        return repository.getDetail(id);
    }
    public long freeBoardDelete(long id) {
        return repository.freeBoardDelete(id);
    }
    public long freeBoardUpdate(long id, String title, String content) {
        return repository.freeBoardUpdate(id, title, content);
    }
}
