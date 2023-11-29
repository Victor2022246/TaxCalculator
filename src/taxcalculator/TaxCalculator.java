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
  
        Prompt p1 = new Prompt();
        p1.Welcome();
        p1.UserValidation();
        
        Employee emp1 = new Employee("Sander", "Soares", 10000);
        Employee emp2 = new Employee("Victor", "Oliveira", 50000);
        Employee emp3 = new Employee("Kevin", "Santos", 27000);
        Employee emp4 = new Employee("Renato", "Ramos", 42000);
        Employee emp5 = new Employee("Felipe", "Paiva", 39000);
        
//        
//  
//        System.out.println(emp1.getEmployeeID());
//        System.out.println(emp2.getEmployeeID());
//       
//        DatabaseWriter dbw = new DatabaseWriter();
//        dbw.addEmployee(emp1);
//        dbw.addEmployee(emp2);
//        dbw.addEmployee(emp3);
//        dbw.addEmployee(emp4);
//        dbw.addEmployee(emp5);
//        
        
        //DATA BASE CONNECTION WAS SUCCESFULL
//         if(DatabaseSetup.setupDB()){
//            System.out.println("Database and Table created");
//        }else{
//            System.out.println("Oh no! There was a database creation problem...");
//        }
//        DatabaseWriter dbw = new DatabaseWriter();
//        if (dbw.addEmployee(ee)){
//            System.out.println("ee added");
//        }
        
    
    }
}

