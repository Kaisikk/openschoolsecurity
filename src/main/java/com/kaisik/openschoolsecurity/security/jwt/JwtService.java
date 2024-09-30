package com.kaisik.openschoolsecurity.security.jwt;

import com.kaisik.openschoolsecurity.dto.JwtAuthenticationDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Сервис по работе с токенами
 */
@Component
@Slf4j
public class JwtService {

    /**
     * Сам секрет
     */
    @Value("NTNv7j0TuYARvmNMmWXo6fKvM4o6nv/aUi9ryX38ZH+L1bkrnD1ObOQ8JAUmHCBq7Iy7otZcyAagBLHVKvvYaIpmMuxmARQ97jUVG16Jkpkp1wXOPsrF9zwew6TpczyHkHgX5EuLg2MeBuiT/qJACs1J0apruOOJCg/gOtkjB4c=")
    private String jwtSecret;

    /**
     * Генерация токена
     *
     * @param email
     * @return
     */
    public JwtAuthenticationDto generateAuthToken(String email) {
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(email));
        jwtDto.setRefreshToken(generateRefreshToken(email));
        return jwtDto;
    }

    /**
     * Получение почты из токена
     *
     * @param token
     * @return
     */
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseEncryptedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    /**
     * Валидация пришедшего токена
     *
     * @param token
     * @return
     */
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (ExpiredJwtException exception) {
            log.error("Expired JwtException");
        } catch (UnsupportedJwtException exception) {
            log.error("UnsupportedJwtException");
        } catch (MalformedJwtException exception) {
            log.error("MalformedJwtException");
        } catch (SecurityException exception) {
            log.error("SecurityException");
        } catch (Exception exception) {
            log.error("Exception", exception);
        }
        return false;
    }

    /**
     * Рефреш токена
     *
     * @param email
     * @param refreshToken
     * @return
     */
    public JwtAuthenticationDto refreshBaseToken(String email, String refreshToken) {
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(email));
        jwtDto.setRefreshToken(refreshToken);
        return jwtDto;
    }

    /**
     * Генерация токена
     *
     * @param email
     * @return
     */
    private String generateJwtToken(String email) {
        Date date = Date.from(LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(email)
                .expiration(date)
                .signWith(getSignKey())
                .compact();
    }

    /**
     * Генерация рефреш токена
     *
     * @param email
     * @return
     */
    private String generateRefreshToken(String email) {
        Date date = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(email)
                .expiration(date)
                .signWith(getSignKey())
                .compact();
    }


    /**
     * Декодировка токена
     *
     * @return
     */
    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
