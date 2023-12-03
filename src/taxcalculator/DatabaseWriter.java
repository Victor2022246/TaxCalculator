/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
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
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
                Statement stmt= conn.createStatement();
                ){
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
//    public boolean addAllEmployee(List<Employee> employeeList){
//        return true;
//}
    /**
     * Update a specif field in our DB's table
     * @param userName The username of the employee requesting the update
     * @param field the column that will be updated
     * @param newValue the new value entered by the user
     * @return true if the update was successful, false otherwise
     * @throws Exception If occurs any errors
     */
    public boolean updateEmploye (String userName,String field,Object newValue){
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
}
