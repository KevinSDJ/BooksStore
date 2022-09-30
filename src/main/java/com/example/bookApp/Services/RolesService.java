package com.example.bookApp.Services;

import com.example.bookApp.Entities.Rol;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RolesService {
    List<Rol> finddAllROles();
    List<Rol> saveRoles(String[] roles);
    void deleteRol(Long id);
    void deleteAllRoles();
}
