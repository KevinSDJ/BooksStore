package com.example.bookApp.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.bookApp.Services.impl.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtFilter  extends OncePerRequestFilter{
    private static final String TOKEN_PREFIX="Bearer ";
    private static final Logger log = LoggerFactory.getLogger(JwtFilter.class);

    @Autowired
    JwtUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            String authorization= request.getHeader("Authorization");
            // compruebo que exista authorization en la cabecera
            if(authorization!=null){
                String token= authorization.substring(TOKEN_PREFIX.length());
                // verifico que se alla enviado el token
                if(token!=null){
                    try {
                        String email = jwtUtil.getEmailFromToken(token);
                        if (!email.isEmpty() && null == SecurityContextHolder.getContext().getAuthentication()) {
                            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                            if (jwtUtil.validate(token, userDetails)) {
                                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                        new UsernamePasswordAuthenticationToken(
                                                userDetails, null, userDetails.getAuthorities());
                                usernamePasswordAuthenticationToken
                                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                                SecurityContextHolder.getContext()
                                        .setAuthentication(usernamePasswordAuthenticationToken);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        log.error("Unable to fetch JWT Token");
                    } catch (ExpiredJwtException e) {
                        log.error("JWT Token is expired");
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }else{
                    log.warn("Couldn't find bearer string, header will be ignored");
                }
            }
            
        filterChain.doFilter(request, response);
    }

    
}