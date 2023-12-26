package com.kmc.groupware.service;

import com.kmc.groupware.dto.MemberRegistEmployeeRankDto;
import com.kmc.groupware.repository.EmployeeRankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeRankService {
    private final EmployeeRankRepository repository;

    public List<MemberRegistEmployeeRankDto> findAllRankList() {
        return repository.findAllRankList();
    }
}
