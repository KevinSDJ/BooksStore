package com.example.bookApp.Services;

import com.example.bookApp.DTO.RequestLoginDTO;
import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.Entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User login(RequestLoginDTO data);
    User findUserById(Long id);
    User register(UserDTO user);
    User createUser(UserDTO user);
    User editUser(UserDTO user,Long id);
    void deleteUserById(Long id);
}
