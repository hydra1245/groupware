package com.kmc.groupware.repository;

import com.kmc.groupware.domain.QPlace;
import com.kmc.groupware.dto.MeetingPlaceDto;
import com.kmc.groupware.dto.MemberRegistPlaceDto;
import com.kmc.groupware.dto.QMeetingPlaceDto;
import com.kmc.groupware.dto.QMemberRegistPlaceDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.kmc.groupware.domain.QPlace.place;

public class PlaceRepositoryImpl implements PlaceRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public PlaceRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<MemberRegistPlaceDto> findAllPlaceList() {
        return queryFactory.
                select(new QMemberRegistPlaceDto(place.placeName))
                .from(place)
                .where(place.onOff.eq("Y").and(place.isConference.eq("N")))
                .fetch();
    }

    @Override
    public List<MeetingPlaceDto> findAllMeetingPlace() {
        return queryFactory
                .select(new QMeetingPlaceDto(place.placeName))
                .from(place)
                .where(place.onOff.eq("Y").and(place.isConference.eq("N")))
                .fetch();
    }


}
