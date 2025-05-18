package com.sametakgul.jwt_token.auth.entity;

import com.sametakgul.jwt_token.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private boolean revoked;

    @ManyToOne
    private User user;
}