package com.sametakgul.jwt_token.auth.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshRequest {
    private String refreshToken;
}