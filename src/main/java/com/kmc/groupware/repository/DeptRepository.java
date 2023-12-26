package com.kmc.groupware.repository;

import com.kmc.groupware.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Long>, DeptRepositoryCustom {

}
