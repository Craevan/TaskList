package com.crevan.tasklist.service;

import com.crevan.tasklist.web.dto.auth.JwtRequest;
import com.crevan.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(final JwtRequest loginRequest);

    JwtResponse refresh(final String refreshToken);
}
