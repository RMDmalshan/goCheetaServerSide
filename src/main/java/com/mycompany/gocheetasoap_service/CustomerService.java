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
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ravin
 */
@WebService(serviceName = "CustomerService")
public class CustomerService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "AddCustomer")
    public boolean AddCustomer(@WebParam(name = "customer") Customer customer) {
        Connection connection = DBUtills.getConnection(); 
       try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);
		
          int rows=stmt.executeUpdate(" INSERT INTO `registercustomer`(`fullName`,"
              + " `username`, `email`, `number`, `password`, `nic`) VALUES ('"+customer.getFullName()+"','"
              +customer.getUsername()+"','"+customer.getEmail()+"','"+customer.getNumber()+"','"+customer.getPassword()+"'"
                      + ",'"+customer.getNic()+"')");
      
           //result = stmt.executeUpdate();
	  		
	    return rows>0;
	
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @WebMethod(operationName = "loginCustomer")
    public Customer loginCustomer(@WebParam(name = "username") String username,@WebParam(name = "password")String password)  {
     
	 final Connection connection = DBUtills.getConnection(); 
		String sql_query = "SELECT *FROM registercustomer where username=? and password=?";
		
		Customer customer = null;
		 
		try {
                      
			
			PreparedStatement stmt = connection.prepareStatement(sql_query);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			// executing the query
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				// defining the UserDetails object
				customer = new Customer();
				
				// setting the all attributes to object from database
				customer.setUsername(username);
				customer.setPassword(password);
				customer.setValidUser(true);
				
			}
			
		} catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
		}
		
		return customer;
	}
    
    
    
    
    
    
   
    
    
    
    
}
