package com.kmc.groupware.repository;

import com.kmc.groupware.domain.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRankRepository extends JpaRepository<EmployeeRank, Long>, EmployeeRankRepositoryCustom {
}
