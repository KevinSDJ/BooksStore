package com.example.bookApp.DTO;

import com.example.bookApp.Entities.Rol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RolesDTO {
    private String[] roles;

    public RolesDTO(String[] roles) {
        this.roles = roles;
    }

    public RolesDTO() {
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String toString() {
        return "RolesDTO{" +
                "roles=" + Arrays.toString(roles) +
                '}';
    }
}
