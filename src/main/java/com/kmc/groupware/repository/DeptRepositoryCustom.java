package com.kmc.groupware.repository;

import com.kmc.groupware.dto.MemberRegistDeptDto;

import java.util.List;

public interface DeptRepositoryCustom {
    List<MemberRegistDeptDto> findDeptAllList();
}
