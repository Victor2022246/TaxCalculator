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
    private String userName = "CCT";
    private String password = "Dublin";
    private int choice;
    Scanner sc = new Scanner(System.in);
    DatabaseReader dbr = new DatabaseReader();
    DatabaseWriter dbw = new DatabaseWriter();
   
    public void adminMenu() throws Exception{
        //Looping the process until Amdin hits option 5
       do{ 
        System.out.println("What would you like to do? \n"
                + "1.Change youw own information\n"
                + "2. Access list of users\n"
                + "3. Remove users\n"
                + "4. Review operations perfomed by users\n"
                + "5. Finish");
        
        
        
        choice = sc.nextInt();
        sc.nextLine();
        
         switch(choice){
            case 1: 
            //Calling the method that was alredy created in Regular user that will display
            //All info based in login and password provided
             RegularUser ru = new RegularUser("CCT", "Dublin");//Giving the parameters, once Admin username and password are just one
                ru.viewDetails();//Displaying details
                ru.regularUserInfo();//Editing whatever he wants
                break;
                
            case 2:
                System.out.println("Follow List of User");
                System.out.println("----------------------------------------------------");
                dbr.displayAllData();
                break;
                
            case 3:
                System.out.println("Which user would you like to delete?\n"
                        + "Please enter his/her EmployeeID and Press Enter");
                
                int deleteEmployee = sc.nextInt();
                sc.nextLine();
                
                boolean delete = dbw.deleteEmployee(deleteEmployee);
                
                if (delete){
                    System.out.println("Employee has been deleted!");
                }else{
                    System.out.println("Error Deleting employee. Please try again.");
                }
                break;
                
            case 4:
                
                break;
                
            case 5:
                System.out.println("Program Closed!!!");
                break;
                
            default:
                System.out.println("Invalid choice, please pick an option between 1 and 5.");
        
    }
       }while(choice!=5);//Program will loop until choices are different than 5
    }
}
