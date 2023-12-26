package com.kmc.groupware.repository;

import com.kmc.groupware.domain.QEmployeeRank;
import com.kmc.groupware.dto.MemberRegistEmployeeRankDto;
import com.kmc.groupware.dto.QMemberRegistDeptDto;
import com.kmc.groupware.dto.QMemberRegistEmployeeRankDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.kmc.groupware.domain.QEmployeeRank.employeeRank;

public class EmployeeRankRepositoryImpl implements EmployeeRankRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public EmployeeRankRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MemberRegistEmployeeRankDto> findAllRankList() {

        return queryFactory.select(new QMemberRegistEmployeeRankDto(employeeRank.rankCode, employeeRank.rankTitle))
                .from(employeeRank)
                .where(employeeRank.onOff.eq("Y"))
                .orderBy(employeeRank.rankCode.asc())
                .fetch();
    }
}
