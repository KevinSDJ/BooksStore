package com.example.bookApp.Services.impl;

import com.example.bookApp.DTO.RequestLoginDTO;
import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.DTO.UserNotRolAndPasswordDTO;
import com.example.bookApp.Entities.Rol;
import com.example.bookApp.Entities.User;
import com.example.bookApp.Exceptions.EmailAlreadyExist;
import com.example.bookApp.Exceptions.NotFound;
import com.example.bookApp.Exceptions.PasswordInvalid;
import com.example.bookApp.Exceptions.UsernameAlreadyExist;
import com.example.bookApp.Repositories.RolRepository;
import com.example.bookApp.Repositories.UserRepository;
import com.example.bookApp.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UsersServiceImpl implements UserService {
    private final static Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try{
            users= userRepository.findAll();
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
    public User login(RequestLoginDTO data) {
        User user = userRepository.findByEmail(data.getEmail());
        if(user == null){
            throw new NotFound("Register not found");
        }
        if(!user.getPassword().contentEquals(data.getPassword())){
            throw new PasswordInvalid("Password invalid");
        }

        return user;
    }

    @Override
    public User register(UserDTO user) {
        User newUser = user.getuserFromDto();
        long usercount= userRepository.count();
        Rol rol;
        if( usercount < 1 ){
            rol = rolRepository.findByName("ADMIN");
            if(rol== null){
                Rol nrol= new Rol("ADMIN");
                rolRepository.save(nrol);
            }
        }else{
            rol = rolRepository.findByName("USER");
            if(rol== null){
                Rol nrol= new Rol("USER");
                rolRepository.save(nrol);
            }
        }

        newUser.setRol(rol);
        if(userRepository.existByEmail(user.getEmail())){
            throw new EmailAlreadyExist("Este email ya se encuentra en uso");
        }
        if(userRepository.existByUsername(user.getUsername())){
            throw new UsernameAlreadyExist("Nombre de usuario existente, eliga otro");
        }
        return userRepository.save(newUser);
    }

    @Override
    public void createUser(UserDTO user) {

        User nuser= user.getuserFromDto();
        user.getRoles().forEach(e->{
            Rol addrol= rolRepository.findByName(e);
            nuser.setRol(addrol);
        });
        if(userRepository.existByEmail(user.getEmail())){
            throw new EmailAlreadyExist("Email ocupado, elige otro gil");
        }
        if(userRepository.existByUsername(user.getUsername())){
            throw new UsernameAlreadyExist("Nombre de usuario en uso");
        }
        userRepository.save(nuser);
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
