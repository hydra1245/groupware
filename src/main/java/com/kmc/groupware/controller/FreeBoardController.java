package com.kmc.groupware.controller;

import com.kmc.groupware.domain.FreeBoard;
import com.kmc.groupware.domain.Notice;
import com.kmc.groupware.dto.*;
import com.kmc.groupware.security.MemberPrincipalDetails;
import com.kmc.groupware.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {
    private final FreeBoardService service;

    @GetMapping("/free-board/regist")
    public String goRegist() {
        return "dist/freeBoard/register";
    }

    @PostMapping("/free-board/regist")
    public ModelAndView freeBoardRegist(@ModelAttribute FreeBoardRegistDto model, @AuthenticationPrincipal MemberPrincipalDetails user) {
        FreeBoard board = new FreeBoard(model.getTitle(), model.getContent(),0,user.getUsername(),
                LocalDateTime.now(), LocalDateTime.now(), "Y");
        service.save(board);

        List<FreeBoardListDto> freeBoardList = service.getList();
        Map<String, Object> viewModel = new HashMap<>();

        viewModel.put("freeBoardList", freeBoardList);
        return new ModelAndView("dist/freeBoard/list", viewModel);
    }

    @GetMapping("/free-board/list")
    public ModelAndView goList() {
        List<FreeBoardListDto> freeBoardList = service.getList();
        Map<String, Object> model = new HashMap<>();

        model.put("freeBoardList", freeBoardList);
        return new ModelAndView("dist/freeBoard/list", model);
    }

    @GetMapping("/free-board/detail/{id}")
    public ModelAndView freeBoardDetail(@PathVariable long id, @AuthenticationPrincipal MemberPrincipalDetails user) {
        long count = service.viewCountUpdate(id);
        FreeBoardDetailDto dto = service.getDetail(id);

        String isAuthor = "N";
        if(dto.getMemberId().equals(user.getMember().getMemberId())) {
            isAuthor = "Y";
        }

        Map<String, Object> model = new HashMap<>();
        model.put("freeBoard",dto);
        model.put("isAuthor",isAuthor);

        return new ModelAndView("dist/freeBoard/detail",model);
    }

    @GetMapping("/free-board/delete/{id}")
    @ResponseBody
    public String freeBoardDelete(@PathVariable long id, @AuthenticationPrincipal MemberPrincipalDetails user) {

        if(isAuthor(id, user).equals("N")) {
            return "N";
        }

        long count = service.freeBoardDelete(id);

        if(count >= 1) {
            return "Y";
        }

        return "N";
    }

    @PostMapping("/free-board/update/{id}")
    @ResponseBody
    public String freeBoardUpdate(@PathVariable long id, @RequestBody NoticeRegistDto updateData,
                               @AuthenticationPrincipal MemberPrincipalDetails user) {

        if(isAuthor(id, user).equals("N")) {
            return "N";
        }

        long count = service.freeBoardUpdate(id, updateData.getTitle(), updateData.getContent());

        if(count >= 1) {
            return "Y";
        }

        return "N";
    }
    private String isAuthor(long id, MemberPrincipalDetails user) {
        FreeBoardDetailDto dto = service.getDetail(id);

        String isAuthor = "N";
        if(dto.getMemberId().equals(user.getMember().getMemberId())) {
            isAuthor = "Y";
        }
        return isAuthor;
    }
}
