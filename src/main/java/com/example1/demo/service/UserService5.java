package com.example1.demo.service;

import com.example1.demo.domain.Role;
import com.example1.demo.domain.User5;
import com.example1.demo.repo.UserRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService5
{
    @Autowired
    UserRepository1 userRepository1;

    @Transactional
    public User5 saveUser(User5 user5){
        user5.setRoles(Collections.singleton(Role.USER));
        user5.setActive(true);
        return userRepository1.saveUser(user5);
    }

    @Transactional
    public User5 findUserByName(String username){
        return userRepository1.findUserByName(username);
    }

    @Transactional
    public User5 findUserByEmail(String email){
        return userRepository1.findUserByEmail(email);
    }

}
