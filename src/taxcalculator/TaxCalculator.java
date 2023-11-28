/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculator;

import java.sql.SQLException;

/**
 *
 * @author victor pc
 */
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO code application logic here
  
        
        
        Employee ee = new Employee("Sander", "Soares", 10000);
        Employee es = new Employee("Victor", "Oliveira", 50000);
        
  
        System.out.println(ee.getEmployeeID());
        System.out.println(es.getEmployeeID());
        
        ee.Salary();
        es.Salary();
        
         if(DatabaseSetup.setupDB()){
            System.out.println("Database and Table created");
        }else{
            System.out.println("Oh no! There was a database creation problem...");
        }
        DatabaseWriter dbw = new DatabaseWriter();
        if (dbw.addEmployee(ee)){
            System.out.println("ee added");
        }
        
        
//        Prompt one = new Prompt();
//        one.Welcome();
//        one.UserValidation();
        
        //        Employee junior = new Employee ("junior", "rodrigues",45000, 2000);
//        
//        System.out.println(junior.getOver());
//        System.out.println(junior.getPaye());
//        System.out.println(junior.getPrsi());
//        System.out.println(junior.getOwn());
//        System.out.println(junior.showCalculation());
    
    }
}

