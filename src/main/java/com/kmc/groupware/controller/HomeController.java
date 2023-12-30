package com.kmc.groupware.controller;

import com.kmc.groupware.domain.Dept;
import com.kmc.groupware.domain.Member;
import com.kmc.groupware.dto.MemberRegistDeptDto;
import com.kmc.groupware.dto.MemberRegistEmployeeRankDto;
import com.kmc.groupware.dto.MemberRegistPlaceDto;
import com.kmc.groupware.dto.MemberRegistRequestDto;
import com.kmc.groupware.service.DeptService;
import com.kmc.groupware.service.EmployeeRankService;
import com.kmc.groupware.service.MemberService;
import com.kmc.groupware.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DeptService deptService;
    private final EmployeeRankService rankService;
    private final PlaceService placeService;
    private final MemberService memberService;

    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/home/test")
    public String test() {
        return "dist/index";
    }

    @GetMapping("/")
    public String loginPage() {
        return "dist/login";
    }

    @GetMapping("/home/member/regist")
    public ModelAndView goMemberRegist(Map<String, Object> model) {
        List<MemberRegistDeptDto> deptList = deptService.getDeptListAll();
        List<MemberRegistEmployeeRankDto> rankList = rankService.findAllRankList();
        List<MemberRegistPlaceDto> placeList = placeService.findAllPlaceList();

        model.put("deptList", deptList);
        model.put("rankList", rankList);
        model.put("placeList", placeList);
        return new ModelAndView("dist/member/register",model);
        //return null;
    }

    @PostMapping("/home/member/regist")
    public String memberRegist(@ModelAttribute MemberRegistRequestDto dto) {
        memberService.userJoin(dto);
        return "dist/login";
    }

    @GetMapping("/home/member/exist/{memberId}")
    @ResponseBody
    public String memberExists(@PathVariable String memberId) {
        Member member = memberService.userExists(memberId);
        if(member == null) {
            return "Y";
        }
        return "N";
    }

    @PostMapping("/home/redis/{key}/{value}")
    @ResponseBody
    public String redisKeyValueSet(@PathVariable String key, @PathVariable String value) {
        ValueOperations<String, String> valueOperations =
                redisTemplate.opsForValue();

        valueOperations.set(key,value);

        return "Y";
    }

    @GetMapping("/home/redis/{key}")
    @ResponseBody
    public String redisGetValue(@PathVariable String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        return valueOperations.get(key);
    }
}
