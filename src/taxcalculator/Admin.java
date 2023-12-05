/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.util.Scanner;

/**
 *
 * @author sande
 */
public class Admin {
    private int choice;
    DatabaseReader dbr = new DatabaseReader();
   
    public void adminMenu(){
        
        System.out.println("What would you like to do? \n"
                + "1.Change youw own information\n"
                + "2. Access list of users\n"
                + "3. Remove users\n"
                + "4. Review operations perfomed by users");
        
        Scanner sc = new Scanner(System.in);
        
        choice = sc.nextInt();
        sc.nextLine();
        
         switch(choice){
            case 1:
                
                break;
                
            case 2:
                System.out.println("Follow List of User");
                System.out.println("----------------------------------------------------");
                dbr.displayAllData();
                break;
                
            case 3:
                
                break;
                
            case 4:
                
                break;
        
    }
}
