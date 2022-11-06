package com.bookStore.bookApp.DTO;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TokenResponseDTO implements Serializable {
   
    
    private String username;
    private String email;
    private String token;
    private Set<String> roles= new HashSet<>();
   
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(String rol) {
        this.roles.add(rol);
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
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponseDTO [username=" + username + ", email=" + email + ", token=" + token + "]";
    }
    
}
