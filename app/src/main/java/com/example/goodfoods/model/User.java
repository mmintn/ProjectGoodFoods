package com.example.goodfoods.model;

import android.provider.BaseColumns;

public class User {

    public static final String TABLE = "user";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
    }

    private int id;
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

}
