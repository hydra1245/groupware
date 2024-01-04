package com.kmc.groupware.repository;

import com.kmc.groupware.domain.MeetingReserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingReserveRepository extends JpaRepository<MeetingReserve, Long>, MeetingReserveRepositoryCustom {
}
