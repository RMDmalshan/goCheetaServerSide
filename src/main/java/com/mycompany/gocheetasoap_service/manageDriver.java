/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gocheetasoap_service;

/**
 *
 * @author ravin
 */
public class manageDriver {
    
    private String registerNumber;
    private String driverName;
    private String  branch;
    private String number;
    private String username;
    private String password;
    private boolean validUser;
    

    public manageDriver() {
    }

    public manageDriver(String registerNumber, String driverName, String branch, String number, String username, String password) {
        this.registerNumber = registerNumber;
        this.driverName = driverName;
        this.branch = branch;
        this.number = number;
        this.username = username;
        this.password = password;
      
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
