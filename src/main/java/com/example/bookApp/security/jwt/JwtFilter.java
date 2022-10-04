package com.example.bookApp.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter  extends OncePerRequestFilter{
    private static final String TOKEN_PREFIX="Bearer ";
    private static final Logger log = LoggerFactory.getLogger(JwtFilter.class);

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            String authorization= request.getHeader("Authorization");
            log.info(authorization);
            if(authorization!=null){
                String token= authorization.substring(TOKEN_PREFIX.length());
                if(token!=null){

                }
            }
            
        filterChain.doFilter(request, response);
    }

    
}