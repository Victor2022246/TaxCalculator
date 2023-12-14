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
 * DatabaseSetup is responsible for setting up the necessary schema
 */
public class DatabaseSetup extends Database {
    //Declaring the boolean to work when database is already setup
    //So if run the main class after the database has been already created, no error message will pop up
    private static boolean isDatabaseSetupDone = false;
     
    /**
     * Method that will connect our database, creating a schema and writing a new Table
     * @return A database connection and a new table created
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        if(isDatabaseSetupDone){
            return true;//Skip setup if already done
        }
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
     // try and catch for trying create  a connection with the database  using the DriverManager, with the properties of the class data base as pharamentesr 
     //Variables were already defined on Database
    try(Connection conn= DriverManager.getConnection(DB_BASE_URL, USER,PASSWORD);
    Statement stmt = conn.createStatement();
    ){   
        // Statement method  execute to write inside mysql data base 
        stmt.execute("CREATE DATABASE IF NOT EXISTS "+ DB_NAME + ";");// Creating the data base 
        stmt.execute("USE "+ DB_NAME + ";");// select the data base to use 
        
        // String to store the table which will be created 
        String sql =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "employeeID INT PRIMARY KEY AUTO_INCREMENT,"
                + "name VARCHAR(255),"
                + "surname VARCHAR(255),"
                + "grossSalary DOUBLE(10,2),"
                + "TaxCredit DOUBLE(10,2),"
                + "PAYE DOUBLE(10,2),"
                + "USC DOUBLE(10,2),"
                + "PRSI DOUBLE(10,2),"
                + "TotalOwe DOUBLE(10,2),"
                + "netSalary DOUBLE(10,2),"
                + "username VARCHAR(255),"
                + "password VARCHAR(255)"
                +  ");";
        stmt.execute(sql);
        //Update to indicate setup has been done
        isDatabaseSetupDone = true;
        return true;//If connection is successfull, return true            
    }catch (Exception e){//Otherwise return the catch and false
    e.printStackTrace();
    return false;
    } 
 }
}
