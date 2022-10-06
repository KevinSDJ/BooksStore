package com.example.bookApp.RestControllers;

import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.Entities.User;
import com.example.bookApp.Services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.bookApp.projections.UsersPr;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UsersController {
    
    @Autowired
    private UsersServiceImpl usersService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("users")
    public ResponseEntity<List<UsersPr>> getAllUsers() throws Exception{

        List<UsersPr> users = usersService.findAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("users/user")
    public ResponseEntity<User> addUser(@RequestBody UserDTO user) throws Exception{
        User usercreate= usersService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(usercreate);

    }
    @PutMapping("users/user/{id}")
    public ResponseEntity<User> editUserById(@RequestBody UserDTO data,@PathVariable("id") Long id){
        User user = usersService.editUser(data,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @DeleteMapping("users/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        usersService.deleteUserById(id);
        return ResponseEntity.ok().body(null);
    }
}
