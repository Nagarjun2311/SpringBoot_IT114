package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RegisterModel {
    
    @Id
    private int id;
    private String userName;
    private String mobileNumber;
    private String email;
    private String password;
    private String confirmPassword;


    public RegisterModel() {
        
    }
    public RegisterModel(int id, String userName, String mobileNumber, String email, String password,
            String confirmPassword) {
        this.id = id;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) 
    {
        this.id = id;
    }
    public String getUserName() 
    {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

