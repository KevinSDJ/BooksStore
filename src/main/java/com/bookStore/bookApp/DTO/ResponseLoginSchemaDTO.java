package com.bookStore.bookApp.DTO;

public class ResponseLoginSchemaDTO {
    private String email="string";
    private String password= "string";

    public ResponseLoginSchemaDTO() {
    }

    public ResponseLoginSchemaDTO(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "ResponseLoginSchemaDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
