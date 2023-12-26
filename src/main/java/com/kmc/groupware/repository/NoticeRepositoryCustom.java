package com.kmc.groupware.repository;

import com.kmc.groupware.dto.NoticeDetailDto;
import com.kmc.groupware.dto.NoticeListDto;

import java.util.List;

public interface NoticeRepositoryCustom {
    List<NoticeListDto> getList();
    long viewCountUpdate(long id);
    NoticeDetailDto getDetail(long id);
    long noticeDelete(long id);
}
