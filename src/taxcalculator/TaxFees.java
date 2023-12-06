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
    public double PAYE;
    public double USC =  0.05;
    public double PRSI =  0.03; 
}
