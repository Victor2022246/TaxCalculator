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
    private double taxableIncome;
    private static int currentID=1;

     public Employee(String name, String surname, double grossSalary, double taxCredit, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.grossSalary = grossSalary;
        this.taxCredit = taxCredit;
        this.username = username.toUpperCase();
        this.password = password;
        this.taxableIncome = grossSalary-taxCredit;
        if(taxableIncome<40000){
            this.PAYE = taxableIncome*0.2;
        }else{
            double payeUpTo40 = 40000*0.2;
                    
            double payeAbove40 = (taxableIncome-40000)*0.4;
            this.PAYE= payeUpTo40+payeAbove40;
        }
        this.totalOwe = (PAYE+(grossSalary*USC)+(grossSalary*PRSI));//Total of taxes will be discounted
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
       this.taxableIncome = grossSalary-taxCredit;
        if(taxableIncome<40000){
            this.PAYE = taxableIncome*0.2;
        }else{
            double payeUpTo40 = 40000*0.2;
                    
            double payeAbove40 = (taxableIncome-40000)*0.4;
            this.PAYE= payeUpTo40+payeAbove40;
        }
         this.totalOwe = (PAYE+(grossSalary*USC)+(grossSalary*PRSI));//Total of taxes will be discounted
        this.netSalary = (grossSalary-totalOwe);//The net salary will be after all deduction
        this.employeeID = currentID;//EmployeeId will start as current ID(value 1)
        currentID++;//Increasing one everytime we create an employee
     }

    Employee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        return PAYE;
    }

    public double getUSC() {
        return taxableIncome*USC;
    }

    public double getPRSI() {
        return taxableIncome*PRSI;
    }

    public double getTotalOwe() {
        return this.totalOwe;
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

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setTaxCredit(double taxCredit) {
        this.taxCredit = taxCredit;
    }
    
    //Method to show the Taxes' deductions
    public String Salary(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Hello " + name+"! This is your Salary calculation" );
        System.out.println("Gross Salary: " + grossSalary + " €");
        System.out.println("TaxCredit: " + taxCredit +" €");
        System.out.println("TAX PAYE: "+ PAYE + " €");
        System.out.println("TAX USC: " + grossSalary*USC + " €");
        System.out.println("TAX PRSI: " + grossSalary*PRSI + " €");
        System.out.println("Total Owe: " + totalOwe + " €");
        System.out.println("NET Salary = " + netSalary + " €");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("The Calculation behind youe NetSalary is:\n"
                + "(TaxableIncome = (Gross Salary-TaxCredit)\n"
                + "(Tax PAYE = (TaxableIncome*20%|40%) (20% will be applied when Taxable Income<40000, otherwise the amount over 40000 is taxed 40%)\n"
                + "(Tax USC = (TaxableIncome*5%)\n"
                + "(Tax PRSI = (TaxableIncome*3%)\n"
                + "(Total Owe = (Tax PAYE+Tax USC+ Tax PRSI)\n"
                + "Net Salary = (GrossSalary - TotalOwe) ");
        return "";
    }
    
public void calculateTax() {
    this.taxableIncome = this.grossSalary - this.taxCredit;

    if (this.taxableIncome < 40000) {
        this.PAYE = this.taxableIncome * 0.2;
    } else {
        double payeUpTo40 = 40000 * 0.2;
        double payeAbove40 = (this.taxableIncome - 40000) * 0.4;
        this.PAYE = payeUpTo40 + payeAbove40;
    }

    this.totalOwe = (this.PAYE + (this.grossSalary * USC) + (this.grossSalary * PRSI));
    this.netSalary = (this.grossSalary - this.totalOwe);
    }
}
