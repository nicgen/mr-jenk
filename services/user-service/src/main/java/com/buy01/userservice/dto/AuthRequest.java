package com.buy01.userservice.dto;

public class AuthRequest {
    private String email;
    private String password;
    private String role; // Optional for login

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
