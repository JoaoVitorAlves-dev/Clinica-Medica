package com.romeuzxg.clinica_medica.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.clinica.medica.secret.key}")
    private String secret;

    @Value("api.clinica.medica-expiration-minutes")
    private long expirationInMinutes;

    public SecretKey getChave() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String gerarToken(String username) {
        return Jwts.builder()
                .signWith(getChave())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationInMinutes))
                .subject(username)
                .compact();
    }

    public String validarToken(String token) {
        return Jwts.parser()
                .verifyWith(getChave())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
