package com.kmc.groupware.controller;

import com.kmc.groupware.domain.MeetingReserve;
import com.kmc.groupware.security.MemberPrincipalDetails;
import com.kmc.groupware.service.MeetingReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MeetingReserveController {
    private final MeetingReserveService meetingReserveService;

    @GetMapping("/meeting-reserve/list")
    public ModelAndView goMeetingReserveList() {
        return null;
    }

    @DeleteMapping("/meeting-reserve/delete/{id}")
    @ResponseBody
    public String meetingDelete(@PathVariable long id, @AuthenticationPrincipal MemberPrincipalDetails user) {
        if(isAuthor(id,user)) {
            long count = meetingReserveService.meetingDelete(id);

            if (count > 0) {
                return "Y";
            }
            else {
                return "N";
            }
        }
        return "N";
    }

    public boolean isAuthor(long id, MemberPrincipalDetails user) {
        Optional<MeetingReserve> reserve = meetingReserveService.findById(id);

        if(reserve.isEmpty()) {
            return false;
        }
        else {
            return reserve.get().getMemberId().equals(user.getUsername());
        }
    }
}
