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
     
    //Method to connnect to the Database
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
     // try and catch for trying create  a connection with the database  using the DriverManager, with the properties of the class data base as pharamentesr 
     //Variables were already defined on Database
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
                + "grossSalary INT(10),"
                + "PAYE(20%) INT(10),"
                + "USC(5%) INT(10),"
                + "PRSI(3%) INT(10),"
                + "netSalary INT(10)"
                +  ");";        
        stmt.execute(sql);
        return true;//If connection is successfull, return true            
    }catch (Exception e){//Otherwise return the catch and false
    e.printStackTrace();
    return false;
    } 
 }
}
