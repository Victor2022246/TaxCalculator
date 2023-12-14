/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 * @author sande
 */
//Class to declare all variables we will use for taxes
public abstract class TaxFees {
    //Declaring in this abstract class make it easier in case we want to change it in the future.
    //Tax Credits variables
    public double PAYE;//Paye will depend on how much the Gross salary is. The whole math is presented in Employee's class
    public double USC =  0.05;//USC will be set as a fixed 5%
    public double PRSI =  0.03; //PRSI will be set as a fixed 3%
}
