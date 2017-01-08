package com.example.claudia.quizproject;

/**
 * Created by Claudia on 24/12/2016.
 */

public class User {
    private String userOnScreen;
    private String email;
    private String password;

    public User(){
    }

    public User(String userName, String email, String password) {
        this.userOnScreen = userName;
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

    public String getUserOnScreen() {
        return userOnScreen;
    }

    public void setUserOnScreen(String user) {
        this.userOnScreen = user;
    }
}
