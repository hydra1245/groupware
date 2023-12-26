package com.kmc.groupware.repository;

import com.kmc.groupware.domain.QDept;
import com.kmc.groupware.dto.MemberRegistDeptDto;
import com.kmc.groupware.dto.QMemberRegistDeptDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.kmc.groupware.domain.QDept.dept;

public class DeptRepositoryCustomImpl implements DeptRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public DeptRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MemberRegistDeptDto> findDeptAllList() {
        return queryFactory
                .select(new QMemberRegistDeptDto(dept.deptCode, dept.deptName))
                .from(dept)
                .where(dept.onOff.eq("Y"))
                .fetch();
    }
}
