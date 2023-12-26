package com.kmc.groupware.dto;

import com.kmc.groupware.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberRegistRequestDto {
    private String memberId;
    private String password;
    private String deptCode;
    private String rankCode;
    private String name;
    private String placeName;

    public Member toEntity(MemberRegistRequestDto dto) {
        Member member = new Member();
        member.setMemberId(dto.memberId);
        member.setDeptCode(dto.deptCode);
        member.setRankCode(dto.rankCode);
        member.setName(dto.name);
        member.setPlaceName(dto.placeName);
        member.setPassword(dto.password);
        member.setOnOff("Y");
        member.setCreateDate(LocalDateTime.now());
        member.setUpdateDate(LocalDateTime.now());
        return member;
    }
}
