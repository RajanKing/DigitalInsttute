package com.example.myapplication;

public class UserHelperClass {
    public UserHelperClass(String name, String username, String email, String phone, String password, String uid) {
        Name = name;
        Username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.uid = uid;
    }

    String Name, Username, email, phone, password,uid;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
