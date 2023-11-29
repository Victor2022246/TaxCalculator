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
    private double totalOwe;
    private static int currentID=1;

    public Employee(String name, String surname, double grossSalary) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        if(grossSalary<40000){
            this.PAYE=PAYE;
        }else {
            this.PAYE = ((grossSalary-40000)*0.4);
        }
        this.totalOwe = ((grossSalary*PAYE)+(grossSalary*USC)+(grossSalary*PRSI));//Total of taxes will be discounted
        this.netSalary = (grossSalary-totalOwe);//The net salary will be after all deduction
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

    public double getTotalOwe() {
        return totalOwe;
    }
    

    public static void setCurrentID(int currentID) {
        Employee.currentID = currentID;
    }
       
    //Method to show the Taxes' deductions
    public String Salary(){
        System.out.println("Hello " + name );
        System.out.println("Gross Salary: " + grossSalary + " €");
        System.out.println("TAX PAYE: "+ grossSalary*PAYE + " €");
        System.out.println("TAX USC: " + grossSalary*USC + " €");
        System.out.println("TAX PRSI: " + grossSalary*PRSI + " €");
        System.out.println("Total Owe: " + totalOwe + " €");
        System.out.println("NET Salary = " + netSalary + " €");
        return "";
    }
}
