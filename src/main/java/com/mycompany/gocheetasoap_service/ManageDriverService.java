/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.gocheetasoap_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ravin
 */
@WebService(serviceName = "ManageDriverService")
public class ManageDriverService {

    /**
     * This is a sample web service operation
     */
    
    
     @WebMethod(operationName = "AddDriver")
    public boolean AddDriver(@WebParam(name = "managedriver") manageDriver managedriver) {
        Connection connection = DBUtills.getConnection(); 
       try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);
		
          int rows=stmt.executeUpdate(" INSERT INTO `manage_deivers`(`registerNumber`,"
              + " `driverName`, `branch`, `number`, `username`, `password`) VALUES ('"+managedriver.getRegisterNumber()+"','"
              +managedriver.getDriverName()+"','"+managedriver.getBranch()+"','"+managedriver.getNumber()+"','"+managedriver.getUsername()+"'"
                      + ",'"+managedriver.getPassword()+"')");
      
           //result = stmt.executeUpdate();
	  		
	    return rows>0;
	
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    
    
    @WebMethod(operationName = "update")
    public boolean update(@WebParam(name = "managedriver")  manageDriver managedriver) {
        try {
             Connection connection = DBUtills.getConnection();
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `manage_deivers` SET  `driverName` = '"
                    + managedriver.getDriverName() +  "', `branch` = '" + managedriver.getBranch()+"', `number` = '" + managedriver.getNumber()+
                    "', `username` = '" + managedriver.getUsername()+ "', `password` = '" + managedriver.getPassword()+"' WHERE (`registerNumber` = '"  + managedriver.getRegisterNumber()+ "')");
            return rows > 0;
           
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    
    
    
    @WebMethod(operationName = "Delete")
     public boolean Delete(@WebParam(name="managedriver")String registerNumber){
    Connection connection = DBUtills.getConnection();
     
        try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);

          int rows=stmt.executeUpdate(" DELETE FROM `manage_deivers` WHERE (`registerNumber`='"+registerNumber+"');");
     
           //result = stmt.executeUpdate();
 
   return rows>0;

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
     
     
     
     
     
     
     
     
     @WebMethod(operationName = "loginDriver")
    public manageDriver loginDriver(@WebParam(name = "username") String username,@WebParam(name = "password")String password)  {
     
	 final Connection connection = DBUtills.getConnection(); 
		String sql_query = "SELECT *FROM manage_deivers where username=? and password=?";
		
		manageDriver managedriver = null;
		 
		try {
                      
			
			PreparedStatement stmt = connection.prepareStatement(sql_query);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			// executing the query
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				// defining the UserDetails object
				managedriver = new manageDriver();
				
				// setting the all attributes to object from database
				managedriver.setUsername(username);
				managedriver.setPassword(password);
				managedriver.setValidUser(true);
				
			}
			
		} catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
		}
		
		return managedriver;
	}
    
     
     
     
     
     
     
     
}
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
