package com.bookStore.bookApp.security;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.bookStore.bookApp.Services.impl.JwtUserDetailsService;
import com.bookStore.bookApp.security.jwt.JwtFilter;

import io.jsonwebtoken.lang.Arrays;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    JwtUserDetailsService userDetailsService;

    @Autowired
    JwtAuthEntryPoint unauthorized;

    @Autowired
    CustomAccessDenied accessDenied;

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
  
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    JwtFilter authenticationJwtFilter () throws Exception{
        return new JwtFilter();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable()
       .exceptionHandling()
       .accessDeniedHandler(accessDenied)
       .authenticationEntryPoint(unauthorized).and()
       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
       .authorizeHttpRequests()
       .antMatchers("/api/auth/**").permitAll()
       .antMatchers(HttpMethod.GET,"/api/categories").permitAll()
       .anyRequest()
       .authenticated()
       .and()
       .httpBasic();

       http.addFilterBefore(authenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        config.setAllowedMethods(Arrays.asList("GET","POST","PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(List.of("Access-Control-Allow-Origin", "X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public void configure(WebSecurity web) throws Exception {
        
        web.ignoring().antMatchers("/static/images/**");
    }

    
    
}
