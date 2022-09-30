package com.example.bookApp.RestControllers;

import com.example.bookApp.DTO.RolesDTO;
import com.example.bookApp.Entities.Rol;
import com.example.bookApp.Services.impl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/")
public class RolesController {

    @Autowired
    RolesServiceImpl rolesService;

    @GetMapping("roles")
    public ResponseEntity<List<Rol>> getAllRoles()
    {
        List<Rol> roles = rolesService.finddAllROles();
        return ResponseEntity.ok(roles);
    }
    @PostMapping("roles")
    public ResponseEntity createRoles(@RequestBody RolesDTO roles)
    {
        List<Rol> rolesave= rolesService.saveRoles(roles.getRoles());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("roles/rol/{id}")
    public ResponseEntity deleteRol(@PathVariable("id") Long id){
        rolesService.deleteRol(id);
        return ResponseEntity.accepted().build();
    }
}
