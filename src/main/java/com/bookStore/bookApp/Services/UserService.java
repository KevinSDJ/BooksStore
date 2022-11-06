package com.bookStore.bookApp.Services;

import com.bookStore.bookApp.DTO.RequestLoginDTO;
import com.bookStore.bookApp.DTO.TokenResponseDTO;
import com.bookStore.bookApp.DTO.UserDTO;
import com.bookStore.bookApp.Entities.User;
import com.bookStore.bookApp.projections.UsersPr;
import java.util.List;


public interface UserService {
    List<UsersPr> findAllUsers();
    TokenResponseDTO login(RequestLoginDTO data);
    User findUserById(Long id);
    User register(UserDTO user);
    User createUser(UserDTO user);
    User editUser(UserDTO user,Long id);
    void deleteUserById(Long id);
}
