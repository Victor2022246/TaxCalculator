/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author victor pc
 */
public class Employee {
    private String name;
    private String surname;
    private int employeeID;
    private int salary;
    private int taxCredits;
    private double paye;
    private double ucs;
    private double prsi;
    private double own;
    private static int currentID=1;
      int over = salary - 40000;
    
     
     public Employee(String name, String surname,  int salary, int taxCredits) {
        this.over =salary - 40000;
          if(over < 0){ this.over = 0 ;} // if the overtime is no positive so its set for been 0 
         this.name = name;
        this.surname = surname;
        this.employeeID = currentID;
        this.salary = salary;
        this.taxCredits = taxCredits;
        this.paye = ((salary - over) * 0.20 ) + (over * 0.40)  ; // calculate the paye basede on 20% fot the amount under 40000 + 40% of the amount over 40000
        this.ucs = salary * 0.05;
        this.prsi = salary * 0.03;
        this.own= ( paye + ucs + prsi - taxCredits);
       
        
        currentID++;
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

    public int getSalary() {
        return salary;
    }

    public int getTaxCredits() {
        return taxCredits;
    }

    public double getPaye() {
        return paye;
    }

    public double getUcs() {
        return ucs;
    }

    public double getPrsi() {
        return prsi;
    }

    public double getOwn() {
        return own;
    }

    public int getOver() {
        return over;
    }
    

    public static int getCurrentID() {
        return currentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTaxCredits(int taxCredits) {
        this.taxCredits = taxCredits;
    }
    
    
    public double showCalculation(){
        System.out.println("hellor mr(s) " + name );
        System.out.println(" this are youy tax calculation");
        System.out.println("Your gross salary is" + salary + "and yor tax credits are " + taxCredits);
        System.out.println("The paye tax based on a 20% rate over 40 thousands + 40% over the overtime is" + paye);
        System.out.println("the UCS base on a rate of 2% is " + ucs + "and the PRSI based on 3% is" + prsi);
        System.out.println(" Your own for the government");
    return own;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
