package com.crevan.tasklist.web.controller;

import com.crevan.tasklist.domain.user.User;
import com.crevan.tasklist.service.AuthService;
import com.crevan.tasklist.service.UserService;
import com.crevan.tasklist.web.dto.auth.JwtRequest;
import com.crevan.tasklist.web.dto.auth.JwtResponse;
import com.crevan.tasklist.web.dto.user.UserDto;
import com.crevan.tasklist.web.dto.validation.OnCreate;
import com.crevan.tasklist.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody final JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody final UserDto userDto) {
        User createdUser = userService.create(userMapper.toEntity(userDto));
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody final String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
