package com.example1.demo.repo;

import com.example1.demo.dao.UserDao;
import com.example1.demo.domain.User5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository1
{
    @Autowired UserDao userDao;

    public User5 saveUser(User5 user5){
        return userDao.saveUser(user5);
    }
    public User5 findUserByName(String username){
        return userDao.findByName(username);
    }
    public User5 findUserByEmail(String findUserByEmail){
        return userDao.findByEmail(findUserByEmail);
    }
}
