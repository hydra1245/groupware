package com.kmc.groupware.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberRegistDeptDto {
    private String DeptCode;
    private String DeptName;

    @QueryProjection
    public MemberRegistDeptDto(String deptCode, String deptName) {
        DeptCode = deptCode;
        DeptName = deptName;
    }



}
