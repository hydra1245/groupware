package com.kmc.groupware.repository;

import com.kmc.groupware.domain.QMeetingReserve;
import com.kmc.groupware.domain.QMeetingReserveMember;
import com.kmc.groupware.dto.MeetingListDto;
import com.kmc.groupware.dto.QMeetingListDto;
import com.kmc.groupware.dto.QMeetingPlaceDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import net.bytebuddy.asm.Advice;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @Override
    public List<MeetingListDto> getMeetingList(String startDate, String placeName) {

        String startDateString = startDate + " 00:00";
        String endDateString = startDate + " 23:59";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(startDateString, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateString, formatter);


        return queryFactory.select(new QMeetingListDto(meetingReserve.id, meetingReserve.placeName,
                meetingReserve.meetingTitle, meetingReserve.memberId,
                meetingReserve.startDate, meetingReserve.endDate))
                .from(meetingReserveMember)
                .where(meetingReserve.placeName.eq(placeName)
                        .and(meetingReserve.startDate.between(startDateTime, endDateTime)))
                .fetch();
    }
}
