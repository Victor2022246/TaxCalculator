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
                + "8.LOGOUT and Finish!");
        //Instantiating our scanner
        Scanner sc = new Scanner(System.in);
        //Instantiating our Writer
        DatabaseWriter dbWriter = new DatabaseWriter();
        //Collecting user's input
        choice = sc.nextInt();
        sc.nextLine();//Cleaning input request
        //For the many options below, user will be asked for a new information
        //Depending each one he wants to change. After that, this new info will be stored
        //This new value will be inserted in that userName's field
        switch(choice){
            case 1:
                System.out.println("Enter new name: ");
                String newName = sc.nextLine().trim();
                dbWriter.updateEmployee(userName, "name", newName);
                System.out.println("------------------------------------------------------------------");
                System.out.println("Name has been updated!");
                break;
                
            case 2:
                System.out.println("Enter new Surname: ");
                String newSurname = sc.nextLine().trim();
                dbWriter.updateEmployee(userName, "surname", newSurname);
                System.out.println("------------------------------------------------------------------");
                System.out.println("Surname has been updated!");
                break;
                
            case 3:
                //Now we are dealing with the grossSalary that influentes other values of taxes and netSalary
                //Therefore, after user inputing new value, the others related must also be updated
                Employee employee = dbReader.getEmployeeData(userName, password);//Creating an employee object
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
                break;
                
            case 4:
                 //Now we are dealing with taxCredit and once again, other data must change after this new input
                 Employee employee1 = dbReader.getEmployeeData(userName, password);//Creating new employee object
                 // Get the current tax credit
                 double currentTaxCredit = employee1.getTaxCredit();
                 // Get the new tax credit from the user
                 System.out.println("Enter new Tax Credit:");
                 double newTaxCredit = sc.nextDouble();//Storing the input
                 sc.nextLine(); // Clean input buffer
                 // Update the tax credit in the employee object
                 employee1.setTaxCredit(newTaxCredit);
                 // Recalculate tax-related fields
                 employee1.calculateTax();//Method that does the math of taxes
                 // Update the employee record in the database
                 dbWriter.updateEmployee(userName, "taxCredit", newTaxCredit);
                 dbWriter.updateEmployee(userName, "PAYE", employee1.getPAYE());
                 dbWriter.updateEmployee(userName, "USC", employee1.getUSC());
                 dbWriter.updateEmployee(userName, "PRSI", employee1.getPRSI());
                 dbWriter.updateEmployee(userName, "totalOwe", employee1.getTotalOwe());
                 dbWriter.updateEmployee(userName, "netSalary", employee1.getNetSalary());
                 System.out.println("------------------------------------------------------------------");//Line for better visualization on the prompt
                 System.out.println("Tax Credit has been updated!");//Outputing that taxCredit has been updated
                 break;
                
            case 5:
                System.out.println("Enter new UserName:");
                String newUsername = sc.nextLine().trim().toUpperCase();
                dbWriter.updateEmployee(userName, "username", newUsername);
                System.out.println("------------------------------------------------------------------");
                System.out.println("Username has been updated!");
                break;
                
            case 6:
                System.out.println("Enter new password:");
                String newPassword = sc.nextLine();
                dbWriter.updateEmployee(userName, "password", newPassword);
                System.out.println("------------------------------------------------------------------");
                System.out.println("Password has been updated!");
                break;
                
            case 7: 
                Employee employee2 = dbReader.getEmployeeData(userName, password);//Creating new object employee
                employee2.Salary();//Displaying its salar wy method,w hen same is requested.
                break;
            case 8:
                System.out.println("------------------------------------------------------------------");
                System.out.println("Logged out!");//Case user opts to finish the prompt
        }
    }while(choice!=8);//keeop looping until he enters 8
        } 
}
