package com.kaisik.openschoolsecurity.dto;

import lombok.Data;

/**
 * Dto для аутентификации с помощью jwt
 */
@Data
public class JwtAuthenticationDto {
    private String token;
    private String refreshToken;
}
