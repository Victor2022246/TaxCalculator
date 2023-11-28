/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author victor pc
 */
public class Employee extends TaxFees{
    
    private String name;
    private String surname;
    private int employeeID;
    private double grossSalary;
    private double netSalary;
    private static int currentID=1;

    public Employee(String name, String surname, double grossSalary) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        this.netSalary = (grossSalary-(grossSalary*PAYE)-(grossSalary*USC)-(grossSalary*PRSI));//The net salary will be after all deduction
        this.employeeID = currentID;//EmployeeId will start as current ID(value 1)
        currentID++;//Increasing one everytime we create an employee
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public double getPAYE() {
        return grossSalary*PAYE;
    }

    public double getUSC() {
        return grossSalary*USC;
    }

    public double getPRSI() {
        return grossSalary*PRSI;
    }

    public static void setCurrentID(int currentID) {
        Employee.currentID = currentID;
    }
    
    
    //Method to show the Taxes' deductions
    public String Salary(){
        System.out.println("Hello " + name );
        System.out.println("Gross Salary: " + grossSalary + " €");
        System.out.println("TAX PAYE(20%): "+ grossSalary*PAYE + " €");
        System.out.println("TAX USC(5%): " + grossSalary*USC + " €");
        System.out.println("TAX PRSI(3%): " + grossSalary*PRSI + " €");
        System.out.println("NET Salary = " + netSalary + " €");
        return "";
    }
    
    public static void resetCurrentID(){
        currentID=1;
    }
}
