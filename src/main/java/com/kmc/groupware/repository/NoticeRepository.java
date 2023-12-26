package com.kmc.groupware.repository;

import com.kmc.groupware.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeRepositoryCustom {
    Notice findById(long id);
}
