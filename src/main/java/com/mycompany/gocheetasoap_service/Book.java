/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gocheetasoap_service;

/**
 *
 * @author ravin
 */
public class Book {
    
    
    private String pickLocation;
    private String dropLocation;
    private String pickDate;
    private String pickTime;
    private String vehicleType;
    private String number;

    public Book() {
    }

    public Book(String pickLocation, String dropLocation, String pickDate, String pickTime, String vehicleType, String number) {
        this.pickLocation = pickLocation;
        this.dropLocation = dropLocation;
        this.pickDate = pickDate;
        this.pickTime = pickTime;
        this.vehicleType = vehicleType;
        this.number = number;
    }

    public String getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(String pickLocation) {
        this.pickLocation = pickLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getPickDate() {
        return pickDate;
    }

    public void setPickDate(String pickDate) {
        this.pickDate = pickDate;
    }

    public String getPickTime() {
        return pickTime;
    }

    public void setPickTime(String pickTime) {
        this.pickTime = pickTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
    
    
    
}
