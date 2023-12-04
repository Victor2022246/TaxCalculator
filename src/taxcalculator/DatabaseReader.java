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
 * The DatabaseReader is responsible for reading inside our table
 * Return desirable variable
 */
public class DatabaseReader extends Database{
    
    //ArrayList to store Employee objects retrieved from the database
    ArrayList <Employee> allEmployees = new ArrayList<>();
    
    
    /**
     * Reads the last Employee ID assigned
     * @return last assigned employee ID
     * @throws Exception in case an error occurs
     */
    public int getLastEmployeeID() throws Exception{
        
        // try a connection 
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
     public boolean checkUserCredentials(String userName, String password) throws Exception{ // method copied from  get user ID
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
           * retrieves the data from all employees by looping through read the data base line by line, and stocking into a array list allEmployees
           *throws Exception if an error occurs.
           */
    
    
    
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
         
         allEmployees.add(emp); // 
         }
         
           
         

         
      }catch (Exception e) {
          e.printStackTrace();
    
    
    
    
    
    
    }
}
    
    /**
     *  get the data  of all employee looking into the database with a filter of employeeID
     * @param employeeID
     * @return employee data, as properties of an object employee 
     */
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
         String username = results.getString("username");
        Employee employee = new Employee(name, surname,grossSalary,id, PAYE, totalOwe, PRSI, USC,netSalary, username );
        
         return employee;
 
         
         
      }catch (Exception e) {
          e.printStackTrace();
    
    
     
    }
        return null;
        
    
    
    
}
}
