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
    
    // properties to stock the data read from database
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
    
// constructor of employee, taking as properties  the data readed from data base
    public Employee(String name, String surname, double grossSalary, int employeeID, double PAYE, double totalOwe, double prsi, double usc,double netSalary) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        if(over<0){ // stock the amount of the salary that stocke the salary after bee subtracted by 40000, if the value is negative set it for zero
            this.PAYE=PAYE20;
        }else{
        this.PAYE=((grossSalary-over)*0.2)+(over*0.4);// take 20 % of the gross salary, and 40 % of what overpass 40000
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
        this.username = username.toUpperCase();
        this.password = password;
        if(over<0){
            PAYE=PAYE20;
        }else{
            PAYE=((grossSalary-over)*0.2)+(over*0.4);
        }
        this.totalOwe = ((grossSalary*PAYE)+(grossSalary*USC)+(grossSalary*PRSI));//Total of taxes will be discounted
        this.netSalary = (grossSalary-totalOwe);//The net salary will be after all deduction
        this.employeeID = currentID;//EmployeeId will start as current ID(value 1)
        currentID++;//Increasing one everytime we create an employee
     }
     //This new constructor will be used on the database reader to retrieve user's info
      public Employee(String name, String surname, double grossSalary, double taxCredit, double PAYE, double  USC, double PRSI, double totalOwe, double netSalary) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        this.taxCredit = taxCredit;
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
      
      
      
      // method to retrieve the information of the object properties
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
        return PAYE;
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
        return username.toUpperCase();
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
