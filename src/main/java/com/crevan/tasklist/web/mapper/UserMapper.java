package com.crevan.tasklist.web.mapper;

import com.crevan.tasklist.domain.user.User;
import com.crevan.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(final User user);

    User toEntity(final UserDto userDto);
}
