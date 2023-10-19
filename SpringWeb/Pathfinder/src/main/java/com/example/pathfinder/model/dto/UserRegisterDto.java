package com.example.pathfinder.model.dto;

import java.util.Objects;

public final class UserRegisterDto {
    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;


    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    //    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null || obj.getClass() != this.getClass()) return false;
//        var that = (UserRegisterDto) obj;
//        return Objects.equals(this.username, that.username) &&
//                Objects.equals(this.fullName, that.fullName) &&
//                Objects.equals(this.email, that.email) &&
//                Objects.equals(this.age, that.age) &&
//                Objects.equals(this.password, that.password) &&
//                Objects.equals(this.confirmPassword, that.confirmPassword);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, fullName, email, age, password, confirmPassword);
//    }
//
//    @Override
//    public String toString() {
//        return "UserRegisterDto[" +
//                "username=" + username + ", " +
//                "fullName=" + fullName + ", " +
//                "email=" + email + ", " +
//                "age=" + age + ", " +
//                "password=" + password + ", " +
//                "confirmPassword=" + confirmPassword + ']';
//    }

}
