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
@WebService(serviceName = "FeedBackService")
public class FeedBackService {

    /**
     * This is a sample web service operation
     */
     @WebMethod(operationName = "CustomerFeedback")
    public boolean CustomerFeedback (@WebParam(name = "feedback") Feedback feedback) {
        Connection connection = DBUtills.getConnection(); 
       try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);
		
          int rows=stmt.executeUpdate(" INSERT INTO `customerfeedback`(`driverName`,"
                + " `feedback`) VALUES ('" +feedback.getDriverName()+"','"+feedback.getFeedback()+"')");
      
           //result = stmt.executeUpdate();
	  		
	    return rows>0;
	
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
