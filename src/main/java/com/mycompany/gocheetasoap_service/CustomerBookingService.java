/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.gocheetasoap_service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ravin
 */
@WebService(serviceName = "CustomerBookingService")
public class CustomerBookingService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "AddCustomerBooking")
    public boolean AddCustomerBooking (@WebParam(name = "book") Book book) {
        Connection connection = DBUtills.getConnection(); 
       try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);
		
          int rows=stmt.executeUpdate(" INSERT INTO `customerbooking`(`pickLocation`,"
              + " `dropLocation`, `pickDate`, `pickTime`, `vehicleType`, `number`) VALUES ('"+book.getPickLocation()+"','"
              +book.getDropLocation()+"','"+book.getPickDate()+"','"+book.getPickTime()+"','"+book.getVehicleType()+"'"
                      + ",'"+book.getNumber()+"')");
      
           //result = stmt.executeUpdate();
	  		
	    return rows>0;
	
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
