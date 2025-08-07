package com.travel.world.Tworld.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "my-super-secret-key-which-is-long-enough123";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(0))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
            .signWith((java.security.Key) getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey())
            .build().parseClaimsJws(token)
            .getBody().getSubject();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(0));
    }

    private Date extractExpiration(String token) {
        return (Date) Jwts.parserBuilder().setSigningKey(getSigningKey())
            .build().parseClaimsJws(token)
            .getBody().getExpiration();
    }

    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return (Key) Keys.hmacShaKeyFor(keyBytes);
    }
}
