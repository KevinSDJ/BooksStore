package com.example.bookApp.Services.impl;

import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.Entities.User;
import com.example.bookApp.Services.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UsersServiceImpl implements UserService {
    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public User registerUser(UserDTO user) {
        return null;
    }

    @Override
    public User createUser(UserDTO user) {
        return null;
    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
