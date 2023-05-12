package com.crevan.tasklist.service.impl;

import com.crevan.tasklist.domain.user.User;
import com.crevan.tasklist.service.AuthService;
import com.crevan.tasklist.service.UserService;
import com.crevan.tasklist.web.dto.auth.JwtRequest;
import com.crevan.tasklist.web.dto.auth.JwtResponse;
import com.crevan.tasklist.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    @Override
    public JwtResponse login(final JwtRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUserName(), loginRequest.getPassword()
        ));
        User user = userService.getByUserName(loginRequest.getUserName());
        jwtResponse.setId(user.getId());
        jwtResponse.setUserName(user.getUsername());
        jwtResponse.setAccessToken(tokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()));
        jwtResponse.setRefreshToken(tokenProvider.createRefreshToken(user.getId(), user.getUsername()));
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(final String refreshToken) {
        return tokenProvider.refreshUserTokens(refreshToken);
    }
}
