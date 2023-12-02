/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sande
 */
public class DatabaseReader extends Database{
    
    
    ArrayList <Employee> allEmployees = new ArrayList<>();
    
    
    //Method to get last employeeID
    public int getLastEmployeeID() throws Exception{
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()){
            
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
        return 0;//If no employeeID is found
    }
    //Method that will check for username and password
     public boolean checkUserCredentials(String userName, String password){
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()){
            
            String sq1 = String.format("SELECT * FROM %s WHERE username='%s' AND password='%s';", TABLE_NAME, userName, password)
            ResultSet resultSet = stmt.executeQuery(sq1);
            
        }catch (Exception e){
            e.printStackTrace();//Output exception
            throw e;
        }
        return 0;//If no employeeID is found
    }
    
    
    public void getAllData(){
    
        
     try(Connection conn= DriverManager.getConnection(DB_URL, USER,PASSWORD);
    Statement stmt = conn.createStatement();
    ){
         /*
         Exercise 
        read each row
         assign the data to a new Patient object
         add the Patient to a list return list 
         */
         
         
       int employeeID = 1;  
         for(int i=0; i< getLastEmployeeID() ; i++){
          employeeID++; 
      // object that stores de result of our query    
       ResultSet results = stmt.executeQuery(String.format(
               "SELECT * FROM %s WHERE id=%d;", TABLE_NAME, employeeID));
     // results is a curso/pointer to a particular row in the results
         //once we are on the row we want, we can extract the data based on the
         //colunm name
         
         
            
         System.out.println(results.getString("employeeID"));
         System.out.println(results.getString("name"));
         String name = results.getString("name");
         System.out.println(results.getString("surname"));
         String surname = results.getString("surname");
         System.out.println(results.getString("grossSalary"));
         double grossSalary = results.getDouble("grossSalary");
         int id = results.getInt("employeeID");
         double netSalary = results.getDouble("netSalary");
          double PAYE = results.getDouble("PAYE");
          double totalOwe = results.getDouble("TotalOwe");
          double USC = results.getDouble("USC");
         double PRSI = results.getDouble("PRSI");
        Employee emp = new Employee(name, surname,grossSalary,id,PAYE, totalOwe, PRSI, USC,netSalary );
         
         allEmployees.add(emp);
         }
         
           
         
//         System.out.println(results.next());// select row 1
//         
//         
//         // if(resusts.next == true)
//         //while(results.next() == true)  reads while you have an other line 
//         
//         
//         
//         System.out.println(results.next());// select row 3
//         System.out.println(results.next());// select row 4
//         System.out.println(results.next());// select row 4
//         
//         
//         // access the results read from the database, using the name of each colunm in the table as a parametes
//         System.out.println(results.getString("name"));
//         System.out.println(results.getString("ID"));
//         
         
         
      }catch (Exception e) {
          e.printStackTrace();
    
    
    
    
    
    
    }
}
    
    public Employee getEmployeeData(int employeeID){
     try(Connection conn= DriverManager.getConnection(DB_URL, USER,PASSWORD);
    Statement stmt = conn.createStatement();
    ){ 
         
      // object that stores de result of our query    
       ResultSet results = stmt.executeQuery(String.format(
               "SELECT * FROM %s WHERE id=%d;", TABLE_NAME, employeeID));
      // results.next();
         
      System.out.println(results.getString("employeeID"));
         System.out.println(results.getString("name"));
         String name = results.getString("name");
         System.out.println(results.getString("surname"));
         String surname = results.getString("surname");
         System.out.println(results.getString("grossSalary"));
         double grossSalary = results.getDouble("grossSalary");
         int id = results.getInt("employeeID");
         double netSalary = results.getDouble("netSalary");
          double PAYE = results.getDouble("PAYE");
          double totalOwe = results.getDouble("TotalOwe");
          double USC = results.getDouble("USC");
         double PRSI = results.getDouble("PRSI");
        Employee employee = new Employee(name, surname,grossSalary,id,PAYE, totalOwe, PRSI, USC,netSalary );
        
         return employee;
 
         
         
      }catch (Exception e) {
          e.printStackTrace();
    
    
     return null;
    }
    
    
    
}
}
