package com.kmc.groupware.service;

import com.kmc.groupware.dto.MemberRegistPlaceDto;
import com.kmc.groupware.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository repository;

    public List<MemberRegistPlaceDto> findAllPlaceList() {
        return repository.findAllPlaceList();
    }
}
