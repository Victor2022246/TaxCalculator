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
 * Videl Link: https://www.youtube.com/watch?v=Ctw_HcrpSOM
 * Video Alternative link: https://vimeo.com/895791928/a3835b59be?share=copy
 */
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        // TODO code application logic here
  

        //DATA BASE AND TABLE CREATION
        //It will be created just oncce, Because it is define to create Only if not Exists
         if(DatabaseSetup.setupDB()){
            System.out.println("Database and Table created");
             System.out.println("---------------------------------------------------------");
        }else{
            System.out.println("Oh no! There was a database creation problem...");
             System.out.println("------------------------------------------------------------");
        }
         
        //Creating 6 employee's objects, including one with ADM credentials
        Employee adm = new Employee("Marcelo", "Almeida",80000, 1750,"CCT", "Dublin" );
        Employee emp1 = new Employee("Sander", "Soares", 35000, 1750, "Sansan", "9876");
        Employee emp2 = new Employee("Victor", "Oliveira", 50000, 1750, "vic" , "vic123");
        Employee emp3 = new Employee("Kevin", "Santos", 96000, 1750, "kevins", "keke123");
        Employee emp4 = new Employee("Renato", "Ramos", 42000, 1750, "linda", "Re123");
        Employee emp5 = new Employee("Felipe", "Paiva", 39000, 1750, "Rere", "re123");
        
       //Instantiating the DatabaseWriter so we can add them into the table
        DatabaseWriter dbw = new DatabaseWriter();
        //Adding each one of the employeed listed above
        //A secondary method will check if they are already in the system. If that is true, they won't be added.
        dbw.addEmployee(adm);
        dbw.addEmployee(emp1);
        dbw.addEmployee(emp2);
        dbw.addEmployee(emp3);
        dbw.addEmployee(emp4);
        dbw.addEmployee(emp5);
        
        //Instantiating our Prompt Class
        Prompt p1 = new Prompt();
        //Calling method which is the main part of this code
        //With all logins and validations inside of it
        p1.UserValidation();
    }
}

