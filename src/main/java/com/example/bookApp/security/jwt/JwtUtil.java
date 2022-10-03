package com.example.bookApp.security.jwt;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil implements Serializable{

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long VALIDITY_TOKEN=  60*60*5;

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    
    
    public String generateToken(Authentication authentication){
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        String authorities= authentication.getAuthorities()
        .stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

        return Jwts.builder()
        .setSubject(authentication.getName())
        .claim("ROLES_", authorities)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TOKEN* 1000))
        .signWith(key)
        .compact();
        
    }
}
