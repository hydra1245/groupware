package com.kmc.groupware.service;

import com.kmc.groupware.domain.Dept;
import com.kmc.groupware.dto.MemberRegistDeptDto;
import com.kmc.groupware.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeptService {
    private final DeptRepository deptRepository;

    public List<MemberRegistDeptDto> getDeptListAll() {
        return deptRepository.findDeptAllList();
    }
}
