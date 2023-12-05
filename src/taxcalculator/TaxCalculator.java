/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculator;

import java.sql.SQLException;

/**
 *
 * @author victor pc
 * Group Member 1 Name: Sander Luiz Santos Soares
 * Group Member 1 Student Number: 2022164
 * Group Member 2 Name: Victor Oliveira
 * Group Member 2 Student Number: 2022246
 * GitHub Link:https://github.com/Victor2022246/TaxCalculator
 */
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        // TODO code application logic here
  

        //DATA BASE AND TABLE CREATION
         if(DatabaseSetup.setupDB()){
            System.out.println("Database and Table created");
        }else{
            System.out.println("Oh no! There was a database creation problem...");
        }
         
//        Employee adm = new Employee("Marcelo", "Almeida",80000, 1750,"CCT", "Dublin" );
//        Employee emp1 = new Employee("Sander", "Soares", 10000, 12000, "Sansan", "9876");
//        Employee emp2 = new Employee("Victor", "Oliveira", 50000, 12000, "vic" , "vic123");
//        Employee emp3 = new Employee("Kevin", "Santos", 27000, 12000, "kevins", "keke123");
//        Employee emp4 = new Employee("Renato", "Ramos", 42000, 12000, "Rere", "Re123");
//        Employee emp5 = new Employee("Felipe", "Paiva", 39000, 12000, "Rere", "re123");
////        
//        DatabaseWriter dbw = new DatabaseWriter();
//        dbw.addEmployee(adm);
//        dbw.addEmployee(emp1);
//        dbw.addEmployee(emp2);
//        dbw.addEmployee(emp3);
//        dbw.addEmployee(emp4);
//        dbw.addEmployee(emp5);
//        Prompt p1 = new Prompt();
//        p1.Welcome();
//        p1.UserValidation();
        
//        

        
        
        
//  
//        System.out.println(emp1.getEmployeeID());
//        System.out.println(emp2.getEmployeeID());
//       
 

        
    
    }
}

