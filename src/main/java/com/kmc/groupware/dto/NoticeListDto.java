package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class NoticeListDto {
    private long id;
    private String title;
    private String content;
    private String memberId;
    private String memberName;
    private int viewCount;

    @QueryProjection
    public NoticeListDto(long id, String title, String content, String memberId, int viewCount, String memberName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.viewCount = viewCount;
        this.memberName = memberName;
    }

}
