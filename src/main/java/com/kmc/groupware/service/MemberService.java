package com.kmc.groupware.service;

import com.kmc.groupware.domain.Member;
import com.kmc.groupware.dto.MemberRegistRequestDto;
import com.kmc.groupware.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;
    private final BCryptPasswordEncoder encoder;

    public void userJoin(MemberRegistRequestDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));

        Member member = dto.toEntity(dto);
        repository.save(member);
    }

    public Member userExists(String memberId) {
        Member member = repository.findByMemberId(memberId);
        return member;
    }
}
