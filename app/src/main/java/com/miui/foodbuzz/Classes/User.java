package com.miui.foodbuzz.Classes;

public class User {
    public String fullName, mobile, email, password;

    public User()
    {

    }

    public User(String fullName, String mobile, String email, String password) {
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
}
