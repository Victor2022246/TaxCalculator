/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sande
 * The DatabaseReader is responsible for reading inside our table
 * Return desirable variable
 */
public class DatabaseReader extends Database{
    /**
     * Reads the last Employee ID assigned
     * @return last assigned employee ID
     * @throws Exception in case an error occurs
     */
    public int getLastEmployeeID() throws Exception{
        //Making connection to database by DriverManager
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()){
            //String query to select the last employee id
            String sq1 = "SELECT MAX(employeeID) FROM " + TABLE_NAME;
            ResultSet resultSet = stmt.executeQuery(sq1);
            //Check if there are any results
            if(resultSet.next()){
                return resultSet.getInt(1);//Getting the value from the last employeeID
            }
        }catch (Exception e){
            e.printStackTrace();//Output exception
            throw e;
        }
        return 0;//If no employeeID is found return 0.
    }
        /**
         * Reads the column username and password, so we can confirm login
         * @param userName 
         * @param password
         * @return true if the credentials are the same as stored in our database, false otherwise
         * @throws Exception if any error occurs
         */
     public boolean checkUserCredentials(String userName, String password) throws Exception{
         //Making connection to database by DriverManager
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()){
            //Query to check if the provided username and password exists in our DB 
            String sq1 = String.format("SELECT * FROM %s WHERE username='%s' AND password='%s';", TABLE_NAME, userName, password);
            ResultSet resultSet = stmt.executeQuery(sq1);
            //Check if there are any results
            return resultSet.next();
        }catch (Exception e){
            e.printStackTrace();//Output exception
            return false;
        }         
     }  
     /**
      * Retrieves employee data based on the provided username and password
      * @param userName userName of the user
      * @param password password of the user
      * @return all the not vital information (except username and password)
      * @throws Exception if an error occurs.
      */
          public Employee getEmployeeData(String userName, String password) throws Exception{
        //Making connection to database by DriverManager
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()){
            //Query to check if the provided username and password exists in our DB 
            String sq1 = String.format("SELECT * FROM %s WHERE username='%s' AND password='%s';", TABLE_NAME, userName, password);
            ResultSet resultSet = stmt.executeQuery(sq1);
            //Check if there are any results
            if(resultSet.next()){
                //create and return a new Employee object with the retrieved data
                //A new constructor was created in order to use below attributes 
                return new Employee(
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getDouble("grossSalary"),
                resultSet.getDouble("taxCredit"),
                resultSet.getDouble("PAYE"),
                resultSet.getDouble("USC"),
                resultSet.getDouble("PRSI"),
                resultSet.getDouble("totalOwe"),
                resultSet.getDouble("netSalary")          
                );
            }
        }catch (Exception e){
            e.printStackTrace();//Output exception          
        } 
            return null;        
     }
          /**
           * Retrieves all employee data. THis method will be only allowed to the Administrator
           */
    public void displayAllData(){  
        //Making connection to database by DriverManager
     try(Connection conn= DriverManager.getConnection(DB_URL, USER,PASSWORD);
    Statement stmt = conn.createStatement()
    ){
         //Query that will select everythig from our table
     String sql = "SELECT * FROM " + TABLE_NAME;
     ResultSet resultSet = stmt.executeQuery(sql);        
        //Loop though the result set and display each row    
       while (resultSet.next()){//While is there any value on nextline, keep reading and then outputting the results following the order
            System.out.println("Employee ID: " + resultSet.getInt("employeeID"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Surname: " + resultSet.getString("surname"));
            System.out.println("Gross Salary: " + resultSet.getDouble("grossSalary"));
            System.out.println("Tax Credit: " + resultSet.getDouble("taxCredit"));
            System.out.println("PAYE: " + resultSet.getDouble("PAYE"));
            System.out.println("USC: " + resultSet.getDouble("USC"));
            System.out.println("PRSI: " + resultSet.getDouble("PRSI"));
            System.out.println("Total Owe: " + resultSet.getDouble("totalOwe"));
            System.out.println("Net Salary: " + resultSet.getDouble("netSalary"));
            System.out.println("UserName: " + resultSet.getString("username"));
            System.out.println("----------------------------------------------------");
         }  
      }catch (Exception e) {
          e.printStackTrace();//Throw error case error occurs
    }
} 
}

