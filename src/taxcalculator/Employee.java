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
    private double over = grossSalary-40000;
    private double taxCredit;
    private String username;
    private String password;
    private static int currentID=1;
    private double prsi=grossSalary * 0.03;
    private double usc = grossSalary* 0.05;
    

    public Employee(String name, String surname, double grossSalary, int employeeID, double PAYE, double totalOwe, double prsi, double usc,double netSalary) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        if(over<0){
            this.PAYE=PAYE20;
        }else{
        this.PAYE=((grossSalary-over)*0.2)+(over*0.4);
        }
        this.totalOwe = ((grossSalary*PAYE)+(grossSalary*USC)+(grossSalary*PRSI));//Total of taxes will be discounted
        this.netSalary = (grossSalary-totalOwe);//The net salary will be after all deduction
        this.employeeID = currentID;//EmployeeId will start as current ID(value 1)
        currentID++;//Increasing one everytime we create an employee
    }
    
    
     public Employee(String name, String surname, double grossSalary, double taxCredit, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        this.taxCredit = taxCredit;
        this.username = username;
        this.password = password;
        if(over<0){
            this.PAYE=PAYE20;
        }else{
        this.PAYE=((grossSalary-over)*0.2)+(over*0.4);
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

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    

    public static void setCurrentID(int currentID) {
        Employee.currentID = currentID;
    }

    public double getTaxCredit() {
        return taxCredit;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
