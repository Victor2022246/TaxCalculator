/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.util.Scanner;

/**
 *
 * @author sande
 */
//Creating prompt which will ask for User's input
public class Prompt {
    
    //Adding scanner to get users input
    Scanner mykb = new Scanner(System.in);

    //Method will get user input and validate
    public void UserNameImput(){
         String userName = mykb.nextLine();
         String password = mykb.nextLine();
        if (userName =="CCT"){
            System.out.println("Please enter your password CCT Administrator");
        }else{
            System.out.println("Welcome student +");
        }
    }
    
    
    
}
