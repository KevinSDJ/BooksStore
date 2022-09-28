package com.example.bookApp.Services;

import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.Entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserByEmail(String email);
    User findUserById(Long id);
    User registerUser(UserDTO user);
    User createUser(UserDTO user);
    User editUser(User user);
    void deleteUserById(Long id);
}
