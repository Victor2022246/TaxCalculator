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
public class RegularUser {
    
    private String userName;
    private String password;
    
    public RegularUser(String userName, String password){
        this.userName = userName.toUpperCase();
        this.password = password;
    }
    
    public void viewDetails(){
        try {
            DatabaseReader dbReader = new DatabaseReader();
            Employee employee = dbReader.getEmployeeData(userName, password);
            
            if(employee !=null){
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
    
    //Regular user data is outputed
    
    public void regularUserInfo(){
        
        int choice;
        do{
        System.out.println("Would you like to change any information:\n"
                + "1.Name\n"
                + "2.Surname\n"
                + "3.Gross salary\n"
                + "4.TaxCredit\n"
                + "5.Username\n"
                + "6.Password");
        
        Scanner sc = new Scanner(System.in);
        DatabaseWriter dbWriter = new DatabaseWriter();
        
        choice = sc.nextInt();
        sc.nextLine();//Cleaning input request
        
        switch(choice){
            case 1:
                System.out.println("Enter new name: ");
                String newName = sc.nextLine().trim();
                System.out.println("Name has been updated!");
                break;
                
            case 2:
                System.out.println("Enter new Surname: ");
                String newSurname = sc.nextLine().trim();
                System.out.println("Surname has been updated!");
                break;
                
            case 3:
                System.out.println("Enter new Gross Salary:");
                double newGrossSalary = sc.nextDouble();
                System.out.println("Gross Salary has been updated!");
                break;
                
            case 4:
                System.out.println("Enter new Tax Credit:");
                double newTaxCredit = sc.nextDouble();
                System.out.println("Tax Credit has been updated!");
                break;
                
            case 5:
                System.out.println("Enter new UserName:");
                String newUsername = sc.nextLine().trim().toUpperCase();
                System.out.println("Username has been updated!");
                break;
                
            case 6:
                System.out.println("Enter new password:");
                String newPassword = sc.nextLine();
                System.out.println("Password has been updated!");
                break;
                
            default:
                System.out.println("Invalid choice, please pick an option between 1 and 6.");
                break;
        }
    }while(choice<1||choice>6);
        } 
}
