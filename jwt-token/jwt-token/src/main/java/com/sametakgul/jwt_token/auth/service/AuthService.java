package com.sametakgul.jwt_token.auth.service;

import com.sametakgul.jwt_token.auth.dto.AuthResponse;
import com.sametakgul.jwt_token.auth.dto.LoginRequest;
import com.sametakgul.jwt_token.auth.dto.LoginResponse;
import com.sametakgul.jwt_token.auth.dto.RegisterRequest;
import com.sametakgul.jwt_token.auth.entity.RefreshToken;
import com.sametakgul.jwt_token.auth.repository.RefreshTokenRepository;
import com.sametakgul.jwt_token.security.JwtUtil;
import com.sametakgul.jwt_token.user.entity.User;
import com.sametakgul.jwt_token.user.model.Role;
import com.sametakgul.jwt_token.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String accessToken = jwtUtil.generateToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);

        saveRefreshToken(user, refreshToken);

        return new AuthResponse(accessToken, refreshToken);
    }

    private void saveRefreshToken(User user, String token) {
        RefreshToken refreshToken = RefreshToken.builder()
                .token(token)
                .revoked(false)
                .user(user)
                .build();

        refreshTokenRepository.save(refreshToken);
    }

    public void logout(String refreshToken) {
        refreshTokenRepository.deleteByToken(refreshToken);
    }


    public AuthResponse register(RegisterRequest request) {
        // email zaten varsa hata fırlat
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Bu email ile kayıtlı kullanıcı zaten var.");
        }

        // şifreyi encode et
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // kullanıcıyı oluştur
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(Role.USER) // default role
                .build();

        userRepository.save(user);

        // token üret
        String accessToken = jwtUtil.generateToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);

        saveRefreshToken(user, refreshToken);

        return new AuthResponse(accessToken, refreshToken);
    }
}
