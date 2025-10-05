package com.gamerdream.backend.Services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.Models.Usuarios.Usuario;

@Service
public class TokenService {
    @Value("${spring.dale}") private String chave;

    private Key chaveF;

    @PostConstruct // Espera a classe ser construída e a chave pegar a variável de ambiente
    public void init() {
        System.out.println("OOOOOOOOOOOOOPAAAAA: " + chave);

        this.chaveF = Keys.hmacShaKeyFor(chave.getBytes());
    }
    
    public String generateToken(UserDetails user) {
        return Jwts.builder()
        .setSubject(user.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
        .signWith(chaveF, SignatureAlgorithm.HS256)
        .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
        .setSigningKey(chaveF)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
    }

    public boolean isTokenValid(String token, Usuario detalhesUsuario) {
        final String username = extractUsername(token);
        return username.equals(detalhesUsuario.getUsername());
    }
}