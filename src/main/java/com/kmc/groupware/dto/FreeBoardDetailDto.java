package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FreeBoardDetailDto {
    private long id;
    private String title;
    private String content;
    private int viewCount;
    private String memberName;
    private String memberId;
    private LocalDateTime CreateDate;

    @QueryProjection
    public FreeBoardDetailDto(String title, String content, int viewCount,
                           String memberName, LocalDateTime createDate, LocalDateTime updateDate,
                           String memberId, long id) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.memberName = memberName;
        CreateDate = createDate;
        UpdateDate = updateDate;
        this.memberId = memberId;
        this.id=id;
    }

    private LocalDateTime UpdateDate;
}
