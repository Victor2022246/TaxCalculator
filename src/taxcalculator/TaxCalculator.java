/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculator;
//Importing scanner
import java.util.Scanner;

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
        
        
        Prompt one = new Prompt();
        one.Welcome();
        one.UserValidation();
                
        //Importing scanner to get user's input
//        Scanner myKB = new Scanner(System.in);
//        
//        //Displaying welcome message
//        System.out.println("Hi!! Welcome to the TAX calculator!\n"
//                + "Please, provide your credentials!\n"
//                + "Are you an Administrator or a User?\n"
//                + "1.Administrator\n"
//                + "2.User");
//        
//        //Verifying type of User
//        int typeOfUser = myKB.nextInt();
//        
//        switch (typeOfUser) {
//            case 1:
//                System.out.println("Please enter your credentials!");
//                break;
//            case 2:
//                System.out.println("Please enter your credentials in order to sign up!");
//                break;
//            default:
//                System.out.println("Please enter the number corresponding to your user type (1 or 2).");
//                break;
//        }
//        
//        System.out.println("Please enter your USERNAME: ");
//        String userName = myKB.nextLine();
//        userName.toUpperCase();
//        
//        System.out.println("Please enter your password:");
//        String password = myKB.nextLine();
//        
//        if(password=="Dublin"&&userName=="CCT"){
//            System.out.println("Welcome CCT Administrator"); 
//        }else if(password!="Dublin"){
//            System.out.println("Please enter your password again:");
//            String password2 = myKB.nextLine();
//            if(password==password2){
//                System.out.println("Welcome User. Now you are signed up!");
//            }
//        }
      
        //        Employee junior = new Employee ("junior", "rodrigues",45000, 2000);
//        
//        System.out.println(junior.getOver());
//        System.out.println(junior.getPaye());
//        System.out.println(junior.getPrsi());
//        System.out.println(junior.getOwn());
//        System.out.println(junior.showCalculation());
    }
    
}
