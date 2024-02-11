package com.example1.demo.user.mapper;

import com.example1.demo.user.domain.User;
import com.example1.demo.user.dto.UserInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserInfoDto toDto(User user);

    User toModel(UserInfoDto userInfoDto);

}
