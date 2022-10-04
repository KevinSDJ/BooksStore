package com.example.bookApp.Services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.bookApp.Entities.User;
import com.example.bookApp.Repositories.UserRepository;

@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userload= userRepository.findByEmail(email);
        List<GrantedAuthority> authorities= new ArrayList<>();
        userload.getRoles().forEach(r->{ authorities.add(new SimpleGrantedAuthority("ROLE_"+r.getName()));});

        return new org.springframework.security.core.userdetails.User(userload.getEmail(),userload.getPassword(), authorities);
        
    }
    
}
