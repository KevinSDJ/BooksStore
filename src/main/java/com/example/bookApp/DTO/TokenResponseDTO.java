package com.example.bookApp.DTO;

public class TokenResponseDTO {
   
    private String username;
    private String email;
    private String token;
    
    public TokenResponseDTO() {
    }
    public TokenResponseDTO(String username, String email, String token) {
        this.username = username;
        this.email = email;
        this.token = token;
    }
    @Override
    public String toString() {
        return "TokenResponseDTO [username=" + username + ", email=" + email + ", token=" + token + "]";
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
    
}
