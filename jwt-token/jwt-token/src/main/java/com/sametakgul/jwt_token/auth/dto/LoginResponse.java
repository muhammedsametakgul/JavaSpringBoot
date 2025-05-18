package com.sametakgul.jwt_token.auth.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;
}