package com.kaisik.openschoolsecurity.dto;

import lombok.Data;

/**
 * Dto для обновления токена
 */
@Data
public class RefreshTokenDto {
    private String refreshToken;

}
