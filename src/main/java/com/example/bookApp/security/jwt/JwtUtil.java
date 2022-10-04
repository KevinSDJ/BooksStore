package com.example.bookApp.security.jwt;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil implements Serializable{

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long VALIDITY_TOKEN=  60*60*5;

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    
    
    public String generateToken(Authentication authentication){
        String authorities= authentication.getAuthorities()
        .stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));
        return Jwts.builder()
        .setSubject(authentication.getName())
        .claim("roles", authorities)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TOKEN* 1000))
        .signWith(key)
        .compact();
        
    }

    public String getEmailFromToken(String token){
        return getClaimFromToken(token,Claims::getSubject);
    }

    public <T> T getClaimFromToken (String token ,Function<Claims, T> resolver){
        final Claims claims= allClaimsFromToken(token);
        return resolver.apply(claims);
    }
    
    public Claims allClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public Boolean isExpired(String token){
        final Date expiration = getExpirationToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    
    public Boolean validate(String token,UserDetails userDetails){
        final String email= getEmailFromToken(token);
        return email.equals(userDetails.getUsername()) && !isExpired(token);
    }
}
