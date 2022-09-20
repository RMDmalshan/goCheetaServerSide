/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.gocheetasoap_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ravin
 */
@WebService(serviceName = "AdminService")
public class AdminService {

    /**
     * This is a sample web service operation
     */
     @WebMethod(operationName = "loginAdmin")
    public Admin loginAdmin(@WebParam(name = "username") String username,@WebParam(name = "password")String password)  {
     
	 final Connection connection = DBUtills.getConnection(); 
		String sql_query = "SELECT *FROM adminlogin where username=? and password=?";
		
		Admin admin = null;
		 
		try {
                      
			
			PreparedStatement stmt = connection.prepareStatement(sql_query);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			// executing the query
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				// defining the UserDetails object
				admin = new Admin();
				
				// setting the all attributes to object from database
				admin.setUsername(username);
				admin.setPassword(password);
				admin.setValidUser(true);
				
			}
			
		} catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
		}
		
		return admin;
	}
}
