/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author sande
 */
public class Admin extends DatabaseReader {
    
    private String firstName;
    private String surName;
    private String age;

    public Admin(String firstName, String surName, String age) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    public void readAlldata() throws Exception{
    
    DatabaseReader dbr = new DatabaseReader();
    dbr.getAllData();
    
    for(int i= 0; i<= dbr.getLastEmployeeID(); i++){
    dbr.allEmployees.get(0);
    
        System.out.println("employee ID " +dbr.allEmployees.get(i).getEmployeeID() +"name "+ dbr.allEmployees.get(i).getName() + " Surname " +dbr.allEmployees.get(i).getSurname() + " gross Salary "+dbr.allEmployees.get(i).getGrossSalary()
        +" Net Salary "+dbr.allEmployees.get(i).getPAYE()+ " PRSI "+dbr.allEmployees.get(i).getPRSI() + " USC  "+dbr.allEmployees.get(i).getUSC());
        
        
        System.out.println("name  "+dbr.allEmployees.get(i).getName());
        System.out.println("Surname " +dbr.allEmployees.get(i).getSurname());
        System.out.println("gross Salary "+dbr.allEmployees.get(i).getGrossSalary());
        System.out.println("gross Salary "+dbr.allEmployees.get(i).getGrossSalary());
        System.out.println("Net Salary "+dbr.allEmployees.get(i).getPAYE());
        System.out.println("PRSI "+dbr.allEmployees.get(i).getPRSI());
         System.out.println("PRSI "+dbr.allEmployees.get(i).getPAYE());
        System.out.println("USC  "+dbr.allEmployees.get(i).getUSC());
        System.out.println("tax Credit "+dbr.allEmployees.get(i).getTaxCredit());
        System.out.println("total owe "+dbr.allEmployees.get(i).getTotalOwe());
    }
    
    }
    
}
