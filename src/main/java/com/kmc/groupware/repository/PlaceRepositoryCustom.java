package com.kmc.groupware.repository;

import com.kmc.groupware.dto.MemberRegistPlaceDto;

import java.util.List;

public interface PlaceRepositoryCustom {
    List<MemberRegistPlaceDto> findAllPlaceList();
}
