package com.ps.controller;

import com.ps.domain.ChangeInfo;
import com.ps.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller
{
    @Autowired
    Service service;

    @GetMapping("get")
    public ModelAndView homePage(){
        return new ModelAndView("homePage");
    }
    @PostMapping("post")
    public ModelAndView postFound(@RequestBody ChangeInfo changeInfo){
        return service.findNecessaryGame(changeInfo);
    }
    @GetMapping(value = "show2")
    public String show() {

        var mav = new ModelAndView();


        mav.addObject("now", 55);
        mav.setViewName("show");

        return "ffff";
    }
}
