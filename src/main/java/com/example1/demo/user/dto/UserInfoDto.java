package com.example1.demo.user.dto;

import org.springframework.stereotype.Component;

@Component
public class UserInfoDto {
    private String password;
    private String username;
    private String email;
    private String phoneNumber;
    private Integer successfulChange;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSuccessfulChange() {
        return successfulChange;
    }

    public void setSuccessfulChange(Integer successfulChange) {
        this.successfulChange = successfulChange;
    }
}
