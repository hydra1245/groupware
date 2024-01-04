package com.kmc.groupware.repository;

import com.kmc.groupware.domain.QMeetingReserve;
import com.kmc.groupware.domain.QMeetingReserveMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.kmc.groupware.domain.QMeetingReserve.*;
import static com.kmc.groupware.domain.QMeetingReserveMember.meetingReserveMember;

public class MeetingReserveRepositoryImpl implements MeetingReserveRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MeetingReserveRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    @Transactional
    public long meetingReserveDelete(long id) {
        queryFactory.delete(meetingReserveMember)
                .where(meetingReserveMember.reserveId.eq(id))
                .execute();

        return queryFactory.delete(meetingReserve)
                .where(meetingReserve.id.eq(id))
                .execute();
    }
}
