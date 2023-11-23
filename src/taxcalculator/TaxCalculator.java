/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author victor pc
 */
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Employee junior = new Employee ("junior", "rodrigues",45000, 2000);
        
        System.out.println(junior.getOver());
        System.out.println(junior.getPaye());
        System.out.println(junior.getPrsi());
        System.out.println(junior.getOwn());
        System.out.println(junior.showCalculation());
    }
    
}
