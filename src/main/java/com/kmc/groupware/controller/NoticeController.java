package com.kmc.groupware.controller;

import com.kmc.groupware.domain.Notice;
import com.kmc.groupware.dto.NoticeDetailDto;
import com.kmc.groupware.dto.NoticeListDto;
import com.kmc.groupware.dto.NoticeRegistDto;
import com.kmc.groupware.security.MemberPrincipalDetails;
import com.kmc.groupware.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService service;

    @GetMapping("/notice/regist")
    public String goRegist() {
        return "dist/notice/register";
    }

    @PostMapping("/notice/regist")
    public ModelAndView noticeRegist(@ModelAttribute NoticeRegistDto model, @AuthenticationPrincipal MemberPrincipalDetails user) {
        Notice notice = new Notice(model.getTitle(), model.getContent(),0,user.getUsername(),
                LocalDateTime.now(), LocalDateTime.now(), "Y");
        service.save(notice);

        List<NoticeListDto> noticeList = service.getList();
        Map<String, Object> viewModel = new HashMap<>();

        viewModel.put("noticeList", noticeList);
        return new ModelAndView("dist/notice/list", viewModel);
    }

    @GetMapping("/notice/list")
    public ModelAndView goList() {
        List<NoticeListDto> noticeList = service.getList();
        Map<String, Object> model = new HashMap<>();

        model.put("noticeList", noticeList);
        return new ModelAndView("dist/notice/list", model);
    }

    @GetMapping("/notice/detail/{id}")
    public ModelAndView noticeDetail(@PathVariable long id, @AuthenticationPrincipal MemberPrincipalDetails user) {
        long count = service.viewCountUpdate(id);
        NoticeDetailDto dto = service.getDetail(id);

        String isAuthor = "N";
        if(dto.getMemberId().equals(user.getMember().getMemberId())) {
            isAuthor = "Y";
        }

        Map<String, Object> model = new HashMap<>();
        model.put("notice",dto);
        model.put("isAuthor",isAuthor);

        return new ModelAndView("dist/notice/detail",model);
    }

    @GetMapping("/notice/delete/{id}")
    @ResponseBody
    public String noticeDelete(@PathVariable long id, @AuthenticationPrincipal MemberPrincipalDetails user) {
        NoticeDetailDto dto = service.getDetail(id);

        String isAuthor = "N";
        if(dto.getMemberId().equals(user.getMember().getMemberId())) {
            isAuthor = "Y";
        }

        if(isAuthor.equals("N")) {
            return "N";
        }

        long count = service.noticeDelete(id);

        if(count >= 1) {
            return "Y";
        }

        return "N";
    }

    @PostMapping("/notice/update/{id}")
    @ResponseBody
    public String noticeUpdate(@PathVariable long id, @RequestBody NoticeRegistDto updateData,
                               @AuthenticationPrincipal MemberPrincipalDetails user) {
        NoticeDetailDto dto = service.getDetail(id);

        String isAuthor = "N";
        if(dto.getMemberId().equals(user.getMember().getMemberId())) {
            isAuthor = "Y";
        }

        if(isAuthor.equals("N")) {
            return "N";
        }

        long count = service.noticeUpdate(id, updateData.getTitle(), updateData.getContent());

        if(count >= 1) {
            return "Y";
        }

        return "N";
    }


}
