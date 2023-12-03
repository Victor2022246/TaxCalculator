/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

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
        System.out.println("Would you like to change any information:\n"
                + "1.Name\n"
                + "2.Surname\n"
                + "3.Gross salary\n"
                + "4.TaxCredit\n"
                + "5.Username\n"
                + "6.Password");
    }
    
}
