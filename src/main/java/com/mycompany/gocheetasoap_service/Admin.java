/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gocheetasoap_service;

/**
 *
 * @author ravin
 */
public class Admin {
    
    private String username;
    private String password;
     private boolean validUser;

    public Admin() {
    }

    public Admin(String username, String password, boolean validUser) {
        this.username = username;
        this.password = password;
        this.validUser = validUser;
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

    public boolean isValidUser() {
        return validUser;
    }

    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }
     
     
     
    
}
