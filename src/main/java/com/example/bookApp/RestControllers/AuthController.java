package com.example.bookApp.RestControllers;

import com.example.bookApp.DTO.RequestLoginDTO;
import com.example.bookApp.DTO.ResponseLoginSchemaDTO;
import com.example.bookApp.DTO.ResponseRegisterSchema;
import com.example.bookApp.DTO.UserDTO;
import com.example.bookApp.Entities.User;
import com.example.bookApp.Services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("register")
    public ResponseEntity<ResponseRegisterSchema> getRegisterSchema(){
        ResponseRegisterSchema registerSchema= new ResponseRegisterSchema();
        return ResponseEntity.ok(registerSchema);
    }
    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody UserDTO data) throws Exception{
        User usersave = usersService.register(data);
        return ResponseEntity.ok(usersave);
    }
    @GetMapping("login")
    public  ResponseEntity<ResponseLoginSchemaDTO> getLoginSchema(){
        ResponseLoginSchemaDTO loginSchema= new ResponseLoginSchemaDTO();
        return ResponseEntity.ok(loginSchema);
    }


    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody RequestLoginDTO data) throws Exception{
        String  token= usersService.login(data);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(token);
    }
}
