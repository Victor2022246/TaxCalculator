/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.util.Scanner;

/**
 *
 * @author sande
 * Will set what our regular user can do
 */
public class RegularUser {
    //Declaring the variables needed to identify the user
    private String userName;
    private String password;
    
    //Constructor with parameters to be used in our methods
    public RegularUser(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    /**
     * Method that will call our reader and reads user's info
     * @Return user's information stored in the DB
     */
    public void viewDetails(){
       
        try {
            //Instantiating our Reader
            DatabaseReader dbReader = new DatabaseReader();
            //Calling the method
            Employee employee = dbReader.getEmployeeData(userName, password);       
            if(employee !=null){//if employee exists
                System.out.println("Employee Details: ");//Print all information, followed by getting the value from the table in our DB
                System.out.println("Name: " + employee.getName());
                System.out.println("Surname: " + employee.getSurname());
                System.out.println("Gross salary: " + employee.getGrossSalary());
                System.out.println("Tax Credit: " + employee.getTaxCredit());
                System.out.println("PAYE: " + employee.getPAYE());
                System.out.println("USC: " + employee.getUSC());
                System.out.println("PRSI: " + employee.getPRSI());
                System.out.println("TotalOwe: " + employee.getTotalOwe());
                System.out.println("Net salary: " + employee.getNetSalary());
                //All the information related to that userName and Password will be displayed to the user.
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * After user's data is outputted, user will choose if wants to edit any
     */
    public void regularUserInfo() throws Exception{
        
        //Instantiating DatabaseReader in tbis method
         DatabaseReader dbReader = new DatabaseReader();
         Employee employee = dbReader.getEmployeeData(userName, password);//Creating an employee object
         //Instantiating our Writer
        DatabaseWriter dbWriter = new DatabaseWriter();
         //Instantiating our scanner
        Scanner sc = new Scanner(System.in);
        //User option will be stored in choice
        int choice;
        do{//User's menu
        System.out.println("------------------------------------------");
        System.out.println("Would you like to change any information:\n"
                + "1.Name\n"
                + "2.Surname\n"
                + "3.Gross salary\n"
                + "4.TaxCredit\n"
                + "5.Username\n"
                + "6.Password\n"
                + "Or would you like to see your Salary calculation again:\n"
                + "7. Salary\n"
                + "8.BACK/LOGOUT");
        
        //validating input
        while(!sc.hasNextInt()){//ask for a number until it is really a number
            System.out.println("Invalid Input, please enter a number between 1 and 8.");
            sc.nextLine();//consume input
        }
        //Collecting user's input
        choice = sc.nextInt();
        sc.nextLine();//Cleaning input request
        //For the many options below, user will be asked for a new information
        //Depending each one he wants to change. After that, this new info will be stored
        //This new value will be inserted in that userName's field
        //All these alterations will be stored in our log's table
        switch(choice){
            case 1:
                System.out.println("Enter new name: ");//Asking user to enter new name
                String newName = sc.nextLine().trim();//storing input and eliminating unnecessary spaces
                dbWriter.updateEmployee(userName, "name", newName);//the username of the employee requesting the update; the field which will be changed
                //the new value for that field
                System.out.println("------------------------------------------------------------------");//line for better visualization
                System.out.println("Name has been updated!");//displaying message that everythig went fine
                dbWriter.updateOperationLog(userName, "Updated name to " +newName);//Storing the altration log in the second table for logs.
                break;
                
            case 2:
                System.out.println("Enter new Surname: ");//Asking for user's new surname
                String newSurname = sc.nextLine().trim();//storing input and eliminating unnecessary spaces
                dbWriter.updateEmployee(userName, "surname", newSurname);//the username of the employee requesting the update; the field which will be changed
                //the new value for that field
                System.out.println("------------------------------------------------------------------");//line for better visualization
                System.out.println("Surname has been updated!");//displaying message that everythig went fine
                dbWriter.updateOperationLog(userName, "Updated Surname to " +newSurname);//Storing the altration log in the second table for logs.
                break;
                
            case 3:
                //Now we are dealing with the grossSalary that influentes other values of taxes and netSalary
                //Therefore, after user inputing new value, the others related must also be updated  
                // Get the current gross salary
                double currentGrossSalary = employee.getGrossSalary();
                // Get the new gross salary from the user
                System.out.println("Enter new Gross Salary:");
                double newGrossSalary = sc.nextDouble();//Storing the input
                sc.nextLine(); // Clean input buffer
                // Update the gross salary in the employee object
                employee.setGrossSalary(newGrossSalary);
                // Recalculate tax-related fields
                employee.calculateTax(); //Method that does the math of taxes
                // Updating the employee data in the database
                dbWriter.updateEmployee(userName, "grossSalary", newGrossSalary);
                dbWriter.updateEmployee(userName, "PAYE", employee.getPAYE());
                dbWriter.updateEmployee(userName, "USC", employee.getUSC());
                dbWriter.updateEmployee(userName, "PRSI", employee.getPRSI());
                dbWriter.updateEmployee(userName, "totalOwe", employee.getTotalOwe());
                dbWriter.updateEmployee(userName, "netSalary", employee.getNetSalary());
                System.out.println("------------------------------------------------------------------");//Line for better visualization
                System.out.println("Gross Salary has been updated!");//Outputing that grossSalary has been updates
                dbWriter.updateOperationLog(userName, "Updated gross salary to " +newGrossSalary);//Storing the altration log in the second table for logs.
                break;
                
            case 4:
                 //Now we are dealing with taxCredit and once again, other data must change after this new input
                 // Get the current tax credit
                 double currentTaxCredit = employee.getTaxCredit();
                 // Get the new tax credit from the user
                 System.out.println("Enter new Tax Credit:");
                 double newTaxCredit = sc.nextDouble();//Storing the input
                 sc.nextLine(); // Clean input buffer
                 // Update the tax credit in the employee object
                 employee.setTaxCredit(newTaxCredit);
                 // Recalculate tax-related fields
                 employee.calculateTax();//Method that does the math of taxes
                 // Update the employee record in the database
                 dbWriter.updateEmployee(userName, "taxCredit", newTaxCredit);
                 dbWriter.updateEmployee(userName, "PAYE", employee.getPAYE());
                 dbWriter.updateEmployee(userName, "USC", employee.getUSC());
                 dbWriter.updateEmployee(userName, "PRSI", employee.getPRSI());
                 dbWriter.updateEmployee(userName, "totalOwe", employee.getTotalOwe());
                 dbWriter.updateEmployee(userName, "netSalary", employee.getNetSalary());
                 System.out.println("------------------------------------------------------------------");//Line for better visualization on the prompt
                 System.out.println("Tax Credit has been updated!");//Outputing that taxCredit has been updated
                 dbWriter.updateOperationLog(userName, "Updated Tax Credit to " +newTaxCredit);//Storing the altration log in the second table for logs.
                 break;
                
            case 5:
                System.out.println("Enter new UserName:");//asking for user's new userName
                String newUsername = sc.nextLine().trim().toUpperCase();//storing input and eliminating unnecessary spaces and changing to upcase
                dbWriter.updateEmployee(userName, "username", newUsername);//the username of the employee requesting the update; the field which will be changed
                employee.setUsername(newUsername);
                //the new value for that field
                System.out.println("------------------------------------------------------------------");//line for better visualization
                System.out.println("Username has been updated!");//displaying message that everythig went fine
                dbWriter.updateOperationLog(userName, "Updated Username to " +newUsername);//Storing the altration log in the second table for logs.
                break;
                
            case 6:
                System.out.println("Enter new password:");//asking for user's new password
                String newPassword = sc.nextLine();//Storing user's input
                employee.setPassword(newPassword);
                dbWriter.updateEmployee(userName, "password", newPassword);//the username of the employee requesting the update; the field which will be changed
                
                //the new value for that field
                System.out.println("------------------------------------------------------------------");//line for better visualization
                System.out.println("Password has been updated!");//displaying message that everythig went fine
                dbWriter.updateOperationLog(userName, "Updated Password to " +newPassword);//Even though it is not safe, I'm adding this function
                //Storing the altration log in the second table for logs.
                break;
                
            case 7:
                employee.Salary();//Displaying its salar wy method,w hen same is requested.
                break;
            case 8:
                System.out.println("------------------------------------------------------------------");//line for better visualization
                System.out.println("Logged out!");//Case user opts to finish the prompt
                System.out.println("------------------------------------------------------------------");//line for better visualization
                break;
                
            default:
                System.out.println("Invalid choice. Please enter a valid number.");
        }
    }while(choice!=8);//keeop looping until he enters 8
        } 
}
