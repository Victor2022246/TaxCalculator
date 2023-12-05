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
                System.out.println("Employee Details: ");
                System.out.println("Name: " + employee.getName());
                System.out.println("Surname: " + employee.getSurname());
                System.out.println("Gross salary: " + employee.getGrossSalary());
                System.out.println("Tax Credit: " + employee.getTaxCredit());
                System.out.println("PAYE: " + employee.getPAYE());
                System.out.println("USC: " + employee.getUSC());
                System.out.println("PRSI: " + employee.getPRSI());
                System.out.println("TotalOwe: " + employee.getTotalOwe());
                System.out.println("Net salary: " + employee.getNetSalary());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * After user's data is outputted, user will choose if wants to edit any
     */
    public void regularUserInfo(){
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
                + "7. No, Closes the program.");
        //Instantiating our scanner
        Scanner sc = new Scanner(System.in);
        //Instantiating our Writer
        DatabaseWriter dbWriter = new DatabaseWriter();
        //Collecting user's input
        choice = sc.nextInt();
        sc.nextLine();//Cleaning input request
        //For the many options below, user will be asked for a new information
        //Depending each one he wants to change. After that, this new info will be stored
        //Replacing the old one
        switch(choice){
            case 1:
                System.out.println("Enter new name: ");
                String newName = sc.nextLine().trim();
                dbWriter.updateEmploye(userName, "name", newName);
                System.out.println("Name has been updated!");
                break;
                
            case 2:
                System.out.println("Enter new Surname: ");
                String newSurname = sc.nextLine().trim();
                dbWriter.updateEmploye(userName, "surname", newSurname);
                System.out.println("Surname has been updated!");
                break;
                
            case 3:
                System.out.println("Enter new Gross Salary:");
                double newGrossSalary = sc.nextDouble();
                dbWriter.updateEmploye(userName, "grossSalary", newGrossSalary);
                System.out.println("Gross Salary has been updated!");
                break;
                
            case 4:
                System.out.println("Enter new Tax Credit:");
                double newTaxCredit = sc.nextDouble();
                dbWriter.updateEmploye(userName, "taxCredit", newTaxCredit);
                System.out.println("Tax Credit has been updated!");
                break;
                
            case 5:
                System.out.println("Enter new UserName:");
                String newUsername = sc.nextLine().trim().toUpperCase();
                dbWriter.updateEmploye(userName, "username", newUsername);
                System.out.println("Username has been updated!");
                break;
                
            case 6:
                System.out.println("Enter new password:");
                String newPassword = sc.nextLine();
                dbWriter.updateEmploye(userName, "password", newPassword);
                System.out.println("Password has been updated!");
                break;
                
            case 7:
                System.out.println("Program Closed!!!");
                
            default:
                System.out.println("Invalid choice, please pick an option between 1 and 6.");
                break;
        }
    }while(choice!=7);//keeop looping until he enters 7
        } 
}
