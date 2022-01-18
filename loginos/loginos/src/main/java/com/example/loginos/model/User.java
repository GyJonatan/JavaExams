package com.example.loginos.model;

public class User {
    private String email;
    private String passwordHash;
    private int loginNumber;

    public User(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.loginNumber = 1;
    }

    public User()
    {
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getLoginNumber() {
        return loginNumber;
    }

    public void incraseLoginNumber() {
        loginNumber++;
    }
}
