    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sande
 * Class that will contain everything Administrator can do
 */
public class Admin {
    //Declaring admin's credentials
    private String userName = "CCT";
    private String password = "Dublin";
    //Storing choice input by ADmin
    private int choice;
    //Instantiating the scanner
    Scanner sc = new Scanner(System.in);
    //Instantiating the Reader and Writer
    DatabaseReader dbr = new DatabaseReader();
    DatabaseWriter dbw = new DatabaseWriter();
   
    /**
     * Method that will have the administrator's menu
     * @throws Exception 
     */
    public void adminMenu() throws Exception{
        //Looping the process until Amdin hits option 4
        //Initialiating do-while loop
       do{ 
        System.out.println("What would you like to do? \n"
                + "1.Change youw own information\n"
                + "2. Access list of users\n"
                + "3. Remove users\n"
                + "4. Review operations perfomed by a user\n"
                + "5. Finish");
        choice = sc.nextInt();//Storing admin's choice after request
        sc.nextLine();//cleaning input buffer
        //Starting switch statement
         switch(choice){
            case 1:
            //Case 1, admin wants to change its own information
            //Calling the method that was alredy created in Regular user that will display
            //All info based in login and password provided
                RegularUser ru = new RegularUser("CCT", "Dublin");//Giving the parameters, once Admin username and password are just one
                ru.viewDetails();//Displaying details
                ru.regularUserInfo();//Editing whatever he wants
                break;
                
            case 2:
                //Case 2: Admin wants to access list of users and all details
                System.out.println("Follow List of User");
                System.out.println("----------------------------------------------------");
                dbr.displayAllData();//Calling method that will display list of users
                break;
                
            case 3:
                //Case3: admin wants to remove an user
                //Prmpt that will ask for the employeeID of the staff he wants to remove
                System.out.println("Which user would you like to delete?\n"
                        + "Please enter his/her EmployeeID and Press Enter");
                //Storing the input
                int deleteEmployee = sc.nextInt();
                sc.nextLine();//cleaning input buffers
                boolean delete = dbw.deleteEmployee(deleteEmployee);//Calling deleteEmployee method               
                if (delete){
                    System.out.println("Employee has been deleted!");//If everything was fine, display user was deleted
                }else{
                    System.out.println("Error Deleting employee. Please try again.");//Throw error message otherwise
                }
                break;
                
            case 4:
               Admin admin = new Admin();
               System.out.println("----------------------------------------------------");
                System.out.println("Enter the Username of the employee you want to review, please!");  
                String log = sc.nextLine().toUpperCase();//storing admin's choice and changing to uppercase
                System.out.println("----------------------------------------------------");
               admin.viewOperationsLog(log);   
               System.out.println("----------------------------------------------------");
               break;
               
            case 5:
                 //Case 5: admin wants to finish the program
                System.out.println("Program Closed!!!");//Program finishes after displaying this.
                break;

            default:
                System.out.println("Invalid choice, please pick an option between 1 and 5.");//In case user does not input valid option
        
    }
       }while(choice!=5);//Program will loop until choices are different than 4
    }
   public String viewOperationsLog(String userName) {
        try {
            // Instantiate DatabaseReader
            DatabaseReader dbReader = new DatabaseReader();

            // Retrieve the operation log for the current user
            List<String> operationsLog = dbReader.getOperationsLog(userName);

            // Display the operation log entries
            System.out.println("Operation Log for " + userName + ":");
            for (String logEntry : operationsLog) {
                System.out.println(logEntry);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
