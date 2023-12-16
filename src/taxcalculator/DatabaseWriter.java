/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author sande
 * The DatabaseWriter class is responsible for writing data to the database
 * extending the common database-related information from Database abstract class
 */
public class DatabaseWriter extends Database{
    /**
     * Adds a new employee to our DB
     * @param employee The Employee object to be added to the DB
     * @return true if employee was successfully added, false otherwise
     * @throws SQLException if there is any error
     */
    public boolean addEmployee(Employee employee) throws SQLException{
        //Making connection with database using the driver manager and credentials
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
                Statement stmt= conn.createStatement();
                ){
            //If employee userName already exists, display that it already exists
             if (employeeExists(employee.getUsername())) {
            System.out.println("Employee with username " + employee.getUsername() + " already exists. Not adding.");
                 System.out.println("-----------------------------------------------------------------------------");
            return false;
             }
                    //Constructing the query to be inserted
                    //%d for integers, '%s' for strings and %f for double/float
                    //using get methods to get all info from employee in Employee's class
                    String sql = String.format("INSERT INTO " + TABLE_NAME + " VALUES ("
                       + "%d,'%s','%s', %f, %f, %f, %f, %f, %f, %f, '%s', '%s');",
                          employee.getEmployeeID(), employee.getName(), employee.getSurname(), employee.getGrossSalary(),employee.getTaxCredit(), employee.getPAYE(),
                          employee.getUSC(), employee.getPRSI(),employee.getTotalOwe(), employee.getNetSalary(), employee.getUsername(), employee.getPassword());
                  stmt.execute(sql);//Execute the query above
                  return true;
    }catch(Exception e){
        e.printStackTrace();
                  return false;
    }
    }
    /**
     * Check if the employee username already exists
     * @param username the employee's username to be checked
     * @return grant access if username not exists, denies otherwise.
     * @throws SQLException 
     */
private boolean employeeExists(String username) throws SQLException {
    //Making connection with database using the driver manager and credentials
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            // Query to check if an employee with the given username already exists
            String sql = String.format("SELECT * FROM %s WHERE username='%s';", TABLE_NAME, username);
            ResultSet resultSet = stmt.executeQuery(sql);
            // Check if there are any results
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Update a specif field in our DB's table
     * @param userName The username of the employee requesting the update
     * @param field the column that will be updated
     * @param newValue the new value entered by the user
     * @return true if the update was successful, false otherwise
     * @throws Exception If occurs any errors
     */
    public boolean updateEmployee (String userName,String field,Object newValue){
        //Making connection with database using the driver manager and credentials
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
                Statement stmt= conn.createStatement();
                ){
            //Declaring the variable outisde so can be used later on
            String sql;
                    if (newValue instanceof String){
                        //Temporary seting the value of the table to a String, adding a new string
                        sql = String.format("UPDATE %s SET %s='%s' WHERE username='%s';", TABLE_NAME, field, newValue, userName);
                                }else{//In case the value is not a string, temporary make it a string and than convert back
                        sql = String.format("UPDATE %s SET %s=%s WHERE username='%s';", TABLE_NAME, field, newValue, userName);
                    }
             
                    stmt.execute(sql);//Execute the query above
                    return true;
    }catch(Exception e){
        e.printStackTrace();//throw error and return false.
                  return false;
    }      
    }
    /**
     * Delete an employee from the database based on employeeID
     * @param employeeID The employeeID of the employee to be deleted
     * @return true if the deletion was completed, false otherwise
     * @throws SQLException if there is any error
     */
    public boolean deleteEmployee(int employeeID){
        //Making connection with database using the driver manager and credentials
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()){
            //Query that will delete desired suser, asking for its employeeID
            String sql = String.format("DELETE FROM %s WHERE employeeID=%d;", TABLE_NAME, employeeID);   
            stmt.execute(sql);           
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
 /**
     * Updates the operation log for a user
     * @param userName  The username of the user performing the operation
     * @param operation The description of the operation
     * @return true if the update was successful, false otherwise
     */
    public boolean updateOperationLog(String userName, String operation) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            // Construct the SQL query to insert a new log entry
            String sql = String.format("INSERT INTO operation_log (username, operation) VALUES ('%s', '%s');",
                    userName, operation);
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
