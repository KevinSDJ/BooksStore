package com.bookStore.bookApp.RestControllers;

import com.bookStore.bookApp.DTO.RequestLoginDTO;
import com.bookStore.bookApp.DTO.ResponseLoginSchemaDTO;
import com.bookStore.bookApp.DTO.ResponseRegisterSchema;
import com.bookStore.bookApp.DTO.TokenResponseDTO;
import com.bookStore.bookApp.DTO.UserDTO;
import com.bookStore.bookApp.Services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<?> register(@RequestBody UserDTO data) throws Exception{
        usersService.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("login")
    public  ResponseEntity<ResponseLoginSchemaDTO> getLoginSchema(){
        ResponseLoginSchemaDTO loginSchema= new ResponseLoginSchemaDTO();
        return ResponseEntity.ok(loginSchema);
    }


    @PostMapping("login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody RequestLoginDTO data) throws Exception{
        TokenResponseDTO tokenResponse= usersService.login(data);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tokenResponse);
    }
}
