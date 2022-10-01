package com.example.bookApp.security.jwt;

import java.io.Serializable;
import java.security.Key;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider implements Serializable{
    
    public static final long JWT_VALIDITY=60*60*5;

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getUsernameJwt(String token){
        return getClaimsForToken(token).getSubject();
    }








    public Claims getClaimsForToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token).getBody();
    }

}
