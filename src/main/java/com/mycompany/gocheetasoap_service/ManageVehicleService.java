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
@WebService(serviceName = "ManageVehicleService")
public class ManageVehicleService {

    /**
     * This is a sample web service operation
     */
   @WebMethod(operationName = "AddVehicle")
    public boolean AddVehicle(@WebParam(name = "managevehicle") manageVehicle managevehicle) {
        Connection connection = DBUtills.getConnection(); 
       try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);
		
          int rows=stmt.executeUpdate(" INSERT INTO `manage_vehicle`(`registerNumber`,"
              + " `driverName`, `branch`, `vehicleNumber`, `vehicleType`) VALUES ('"+managevehicle.getRegisterNumber()+"','"
              +managevehicle.getDriverName()+"','"+managevehicle.getBranch()+"','"+managevehicle.getVehicleNumber()+"','"+managevehicle.getVehicleType()+"')");
                      
      
           //result = stmt.executeUpdate();
	  		
	    return rows>0;
	
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    
    
    
    
    @WebMethod(operationName = "updateVehicle")
    public boolean updateVehicle(@WebParam(name = "managevehicle")  manageVehicle managevehicle) {
        try {
             Connection connection = DBUtills.getConnection();
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE `manage_vehicle` SET  `driverName` = '"
                    + managevehicle.getDriverName() +  "', `branch` = '" + managevehicle.getBranch()+"', `vehicleNumber` = '" + managevehicle.getVehicleNumber()+
                    "', `vehicleType` = '" + managevehicle.getVehicleType()+ "' WHERE (`registerNumber` = '"  + managevehicle.getRegisterNumber()+ "')");
            return rows > 0;
           
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    
    
    
    
    
    @WebMethod(operationName = "DeleteVehicle")
     public boolean DeleteVehicle(@WebParam(name="managevehicle")String registerNumber){
    Connection connection = DBUtills.getConnection();
     
        try{
          Statement stmt=connection.createStatement();
           // PreparedStatement stmt = connection.prepareStatement(sql_query);

          int rows=stmt.executeUpdate(" DELETE FROM `manage_vehicle` WHERE (`registerNumber`='"+registerNumber+"');");
     
           //result = stmt.executeUpdate();
 
   return rows>0;

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    
    
    
    
}
