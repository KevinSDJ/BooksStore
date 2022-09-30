package com.example.bookApp.DTO;

import com.example.bookApp.Entities.Rol;
import com.example.bookApp.Entities.User;

import java.util.List;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<Rol> roles;

    public UserDTO(String username, String email, String password, Set<Rol> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public UserDTO(String username, String email, Set<Rol> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public UserDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    public void setRol(Rol rol){
        this.roles.add(rol);
    }

    public User getuserFromDto(){
        User user = new User();
        user.setEmail(this.email);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRoles(this.roles);
        return user;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
