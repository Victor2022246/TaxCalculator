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
 */
public class DatabaseWriter extends Database{
    
    public boolean addEmployee(Employee employee) throws SQLException{
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
                Statement stmt= conn.createStatement();
                ){
                    String sql = String.format("INSERT INTO " + TABLE_NAME + " VALUES ("
                       + "%d,'%s','%s', %f, %f, %f, %f, %f, %f, %f, '%s', '%s');",
                          employee.getEmployeeID(), employee.getName(), employee.getSurname(), employee.getGrossSalary(),employee.getTaxCredit(), employee.getPAYE(),
                          employee.getUSC(), employee.getPRSI(),employee.getTotalOwe(), employee.getNetSalary(), employee.getUsername(), employee.getPassword());
                  stmt.execute(sql);
                  return true;
    }catch(Exception e){
        e.printStackTrace();
                  return false;
    }
    }
    public boolean addAllEmployee(List<Employee> employeeList){
        return true;
}
}
