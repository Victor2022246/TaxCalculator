/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victor pc
 */
public class DatabaseSetup extends Database {
     
    
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        
        
      // try and catch for trying create  a connection with the database  using the DriverManager, with the properties of the class data base as pharamentesr  
    try(Connection conn= DriverManager.getConnection(DB_BASE_URL, USER,PASSWORD);
    Statement stmt = conn.createStatement();
    ){
        
        // Statement method  execute to wright inside mysql data base 
        
        stmt.execute("CREATE DATABASE IF NOT EXISTS "+ DB_NAME + ";");// Creating the data base 
        stmt.execute("USE "+ DB_NAME + ";");// select the data base to use 
        
        // String to store the table which will be created 
        String sql =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "name VARCHAR(255),"
                + "surname VARCHAR(300),"
                + "employeeID INT(10),"
                + "salary INT(10),"
                + "tax_credits INT(10),"
                + "paye INT(10),"
                + "usc INT(10),"
                + "prsi INT(10),"
                + "own INT(10)"
                +  ");";
        
        stmt.execute(sql);
        return true;
               
             
    
    }catch (Exception e){
    e.printStackTrace();
    return false;
    }
    
    
 }
}
