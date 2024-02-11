package com.example1.demo.user.service;

import com.example1.demo.user.domain.User;
import com.example1.demo.user.dto.UserInfoDto;
import com.example1.demo.user.mapper.UserMapper;
import com.example1.demo.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public UserInfoDto getUserInfo(String id) throws Exception {
        return userMapper.toDto(userRepository.findById(Long.parseLong(id)).orElseThrow(Exception::new));
    }

    public void deleteUserAccount(String id) {
        userRepository.deleteById(Long.parseLong(id));
    }

    public void createUser(UserInfoDto userInfoDto) {
        userRepository.save(userMapper.toModel(userInfoDto));
    }

    public void updateUser(String id, UserInfoDto userInfoDto) throws Exception {
        userRepository.findById(Long.parseLong(id)).orElseThrow(Exception::new);
        User user = userMapper.toModel(userInfoDto);
        user.setId(Long.parseLong(id));
        userRepository.save(user);
    }
}
