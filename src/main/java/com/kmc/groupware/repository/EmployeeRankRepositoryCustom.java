package com.kmc.groupware.repository;

import com.kmc.groupware.dto.MemberRegistEmployeeRankDto;

import java.util.List;

public interface EmployeeRankRepositoryCustom {
    List<MemberRegistEmployeeRankDto> findAllRankList();
}
