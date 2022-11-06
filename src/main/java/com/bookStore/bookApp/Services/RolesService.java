package com.bookStore.bookApp.Services;

import com.bookStore.bookApp.Entities.Rol;
import java.util.List;


public interface RolesService {
    List<Rol> finddAllROles();
    List<Rol> saveRoles(String[] roles);
    void deleteRol(Long id);
    void deleteAllRoles();
}
