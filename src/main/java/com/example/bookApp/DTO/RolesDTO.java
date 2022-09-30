package com.example.bookApp.DTO;

import java.util.Arrays;

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
