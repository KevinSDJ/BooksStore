package com.example.bookApp.RestControllers;

import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.DTO.UserNotRolAndPasswordDTO;
import com.example.bookApp.Entities.User;
import com.example.bookApp.Services.impl.UsersServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UsersController {
    private static final Logger log= LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() throws Exception{
        // retorno de usuarios ok
        // manejo de errores  ok
        List<User> users = usersService.findAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("users/user")
    public ResponseEntity addUser(@RequestBody UserDTO user) throws Exception{
        User usercreted= usersService.createUser(user);
        log.info(usercreted.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("users/user/{id}")
    public ResponseEntity editUserById(@RequestBody UserDTO data,@PathVariable("id") Long id){
        User user = usersService.editUser(data,id);
        return ResponseEntity.ok(user);
    }
}
