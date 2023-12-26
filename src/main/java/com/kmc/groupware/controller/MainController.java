package com.kmc.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("/main/*")
public class MainController {

    @GetMapping("/main")
    public ModelAndView mainPage() {
        Map<String, String> model = new HashMap<>();
        return new ModelAndView("/dist/main/index", model);
    }

}
