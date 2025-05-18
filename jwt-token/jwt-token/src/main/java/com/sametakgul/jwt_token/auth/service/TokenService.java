package com.sametakgul.jwt_token.auth.service;

import com.sametakgul.jwt_token.auth.dto.AuthResponse;
import com.sametakgul.jwt_token.auth.dto.RefreshRequest;
import com.sametakgul.jwt_token.security.JwtUtil;
import com.sametakgul.jwt_token.user.entity.User;
import com.sametakgul.jwt_token.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sametakgul.jwt_token.security.CustomUserDetails;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthResponse refresh(RefreshRequest request) {
        String email = jwtUtil.extractUsername(request.getRefreshToken());

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        CustomUserDetails userDetails = new CustomUserDetails(user);

        if (!jwtUtil.isTokenValid(request.getRefreshToken(), userDetails)) {
            throw new RuntimeException("Invalid refresh token");
        }

        String newAccessToken = jwtUtil.generateToken(user);
        String newRefreshToken = jwtUtil.generateRefreshToken(user);

        return new AuthResponse(newAccessToken, newRefreshToken);
    }
}