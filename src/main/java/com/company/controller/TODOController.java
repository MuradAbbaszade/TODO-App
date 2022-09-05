package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TODOController {
    @GetMapping
    public ModelAndView showTodoPage(){
        ModelAndView mv = new ModelAndView("todo");
        return mv;
    }
}
