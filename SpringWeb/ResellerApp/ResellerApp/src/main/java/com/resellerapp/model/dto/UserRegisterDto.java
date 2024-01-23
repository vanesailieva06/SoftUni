package com.resellerapp.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterDto() {
    }

    @NotNull
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters (inclusive of 3 and 20).")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Email cannot be null")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters (inclusive of 3 and 20).")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters (inclusive of 3 and 20).")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
