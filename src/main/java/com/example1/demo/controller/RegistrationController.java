package com.example1.demo.controller;

import com.example1.demo.domain.User5;
import com.example1.demo.service.UserService5;
import com.example1.demo.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class RegistrationController
{
    @Autowired UserValidator userValidator;
    @Autowired
    UserService5 userService5;

    @GetMapping("/registration")
    public ModelAndView registration()
    {
        var mav = new ModelAndView();
        mav.addObject("user",new User5());
        mav.setViewName("registration");
        return mav;
    }
    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute User5 user5)
    {
        var mav = userValidator.userRegisterValidator(user5);
        if(mav.getModel().size()!=0){
            return mav;
        }
        userService5.saveUser(user5);
        mav.setViewName("login");
        return mav;
    }
}
