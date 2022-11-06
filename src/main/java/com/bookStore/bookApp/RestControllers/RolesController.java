package com.bookStore.bookApp.RestControllers;

import com.bookStore.bookApp.DTO.RolesDTO;
import com.bookStore.bookApp.Entities.Rol;
import com.bookStore.bookApp.Services.impl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    public ResponseEntity<List<Rol>> createRoles(@RequestBody RolesDTO roles)
    {
        List<Rol> rolesave= rolesService.saveRoles(roles.getRoles());
        return ResponseEntity.ok(rolesave);
    }

    @DeleteMapping("roles/rol/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable("id") Long id){
        rolesService.deleteRol(id);
        return ResponseEntity.ok("User with id: "+ id.toString()+ "has delete");
    }
}
