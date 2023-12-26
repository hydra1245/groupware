package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberRegistEmployeeRankDto {

    private String rankCode;
    private String rankTitle;

    @QueryProjection
    public MemberRegistEmployeeRankDto(String rankCode, String rankTitle) {
        this.rankCode = rankCode;
        this.rankTitle = rankTitle;
    }



}
