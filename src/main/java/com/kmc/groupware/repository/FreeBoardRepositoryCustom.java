package com.kmc.groupware.repository;

import com.kmc.groupware.dto.FreeBoardDetailDto;
import com.kmc.groupware.dto.FreeBoardListDto;
import com.kmc.groupware.dto.NoticeDetailDto;
import com.kmc.groupware.dto.NoticeListDto;

import java.util.List;

public interface FreeBoardRepositoryCustom {
    List<FreeBoardListDto> getList();
    long viewCountUpdate(long id);
    FreeBoardDetailDto getDetail(long id);
    long freeBoardDelete(long id);
    long freeBoardUpdate(long id, String title, String content);
}
