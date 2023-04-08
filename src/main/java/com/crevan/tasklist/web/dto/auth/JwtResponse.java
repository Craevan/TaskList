package com.crevan.tasklist.web.dto.auth;

import lombok.Data;

@Data
public class JwtResponse {

    private Long id;
    private String userName;
    private String accessToken;
    private String refreshToken;
}
