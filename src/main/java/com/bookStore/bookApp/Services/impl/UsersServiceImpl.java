package com.bookStore.bookApp.Services.impl;

import com.bookStore.bookApp.DTO.RequestLoginDTO;
import com.bookStore.bookApp.DTO.TokenResponseDTO;
import com.bookStore.bookApp.DTO.UserDTO;
import com.bookStore.bookApp.Entities.Rol;
import com.bookStore.bookApp.Entities.User;
import com.bookStore.bookApp.Exceptions.AlreadyExist;
import com.bookStore.bookApp.Exceptions.NotFound;
import com.bookStore.bookApp.Exceptions.users.PasswordInvalid;
import com.bookStore.bookApp.Repositories.RolRepository;
import com.bookStore.bookApp.Repositories.UserRepository;
import com.bookStore.bookApp.Services.UserService;
import com.bookStore.bookApp.security.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.bookStore.bookApp.projections.UsersPr;;

@Service
@Transactional
public class UsersServiceImpl implements UserService {
    private final static Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<UsersPr> findAllUsers() {
        List<UsersPr> users = new ArrayList<>();
        try{
            users=userRepository.findAllNotRolPassword();
        }catch (Exception e){
            log.error("Fail process intern findAllUsers:{}" ,e.getMessage());
        }
        if(users.size()<1){
            throw new NotFound("No existen usuarios registrados");
        }
        return users;

    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NotFound("User not exist");
        }
        return user.get();
    }

    @Override
    public TokenResponseDTO login(RequestLoginDTO data) {
        User user = userRepository.findByEmail(data.getEmail());
        if(user == null){
            throw new NotFound("User not found invalid");
        }
        Boolean d= passwordEncoder.matches(data.getPassword(),user.getPassword());
        if(d== false){
            throw new PasswordInvalid("Password invalid");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(),data.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication);
        TokenResponseDTO response= new TokenResponseDTO();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setToken(token);
        user.getRoles().forEach(e->{
            response.setRoles(e.getName());
        });

        return response;
    }

    @Override
    public User register(UserDTO user) {
        User newUser = user.getuserFromDto();
        long usercount= userRepository.count();
        Rol rol;
        if( usercount < 1 ){
            rol = rolRepository.findByName("ADMIN");
        }else{
            rol = rolRepository.findByName("USER");
        }
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRol(rol);
        if(userRepository.existByEmail(user.getEmail())){
            throw new AlreadyExist("email already in use, choose another");
        }
        if(userRepository.existByUsername(user.getUsername())){
            throw new AlreadyExist("username already in use, choose another");
        }
        return userRepository.save(newUser);
    }

    @Override
    public User createUser(UserDTO user) {

        User nuser= user.getuserFromDto();
        nuser.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().forEach(e->{
            Rol addrol= rolRepository.findByName(e);
            nuser.setRol(addrol);
        });
        if(userRepository.existByEmail(user.getEmail())){
            throw new AlreadyExist("email already in use, choose another");
        }
        if(userRepository.existByUsername(user.getUsername())){
            throw new AlreadyExist("username already in use, choose another");
        }
        User us= userRepository.save(nuser);
        return us;
    }

    @Override
    public User editUser(UserDTO data,Long id) {
        User userdb= userRepository.findById(id).get();
        userdb.setUsername(data.getUsername());
        userdb.setEmail(data.getEmail());
        userdb.getRoles().clear();
        data.getRoles().forEach(e->{
            Rol nrol= rolRepository.findByName(e);
            userdb.setRol(nrol);
        });
        return userRepository.save(userdb);
    }

    @Override
    public void deleteUserById(Long id) {
        try{

            userRepository.deleteById(id);
            
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    
}
