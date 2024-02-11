package com.example1.demo.validation;

import com.example1.demo.domain.User5;

import com.example1.demo.service.UserService5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
@Component
public class UserValidator
{

    @Autowired
    UserService5 userService5;

    public ModelAndView userRegisterValidator(User5 user5)
    {
        var mav = new ModelAndView();
        mav.setViewName("registration");

        if(userService5.findUserByName(user5.getUsername()) != null)
        {
            mav.addObject("usernameMessage", "This username already exists!");
        }
        if(user5.getUsername().length() < 6)
        {
            mav.addObject("usernameMessage", "Username length should to have more than 6 symbols");

        }
        if(user5.getPassword().length() < 6)
        {
            mav.addObject("passwordMessage", "Password length should to have more than 6 symbols");

        }
        if(userService5.findUserByEmail(user5.getEmail()) != null)
        {
            mav.addObject("emailMessage", "You have already profile!");

        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(!user5.getEmail().matches(emailRegex))
        {
            mav.addObject("emailMessage", "Invalid email");
        }
        return mav;
    }
}
