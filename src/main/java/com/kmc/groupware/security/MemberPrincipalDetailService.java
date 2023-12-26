package com.kmc.groupware.security;

import com.kmc.groupware.domain.Member;
import com.kmc.groupware.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberPrincipalDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(username);
        if(member == null) {
            throw new UsernameNotFoundException(username + "을 찾을 수 없습니다.");
        }
        else if (member.getOnOff().equals("N")) {
            throw new UsernameNotFoundException("활성화 되지 않은 계정입니다.");
        }
        return new MemberPrincipalDetails(member);
    }
}
