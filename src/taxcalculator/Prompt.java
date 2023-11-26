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
    
    public String userName;
    public String password;
    
    //Adding scanner to get users input
    Scanner mykb = new Scanner(System.in);
    //Method that will display the welcome message 
    
    public void Welcome(){
        //Displaying welcome message
        System.out.println("Hi!! Welcome to the TAX calculator!\n"
                + "Please, provide your credentials!\n"
                + "Are you an Administrator or a User?\n"
                + "1.Administrator\n"
                + "2.User");
        
    }
    
    public void TypeOfUser(){
            int typeOfUser = mykb.nextInt();
            
            if(typeOfUser==1){
                System.out.println("Please enter your credentials.");
            }else if(typeOfUser==2){
                System.out.println("Welcome User. Please sign up:");
            }else{
                System.out.println("Please enter the numbers 1 or 2.");
            }
            
    }
    
    //Method will get user surname
    public void UserNameImput(){
        //Ask user for username
        System.out.println("UserName: ");
        //Collecting user's input
        String userName = mykb.nextLine();
        //IF user input is CCT, asks for password
        System.out.println("Password: ");
        if (userName=="CCT"){
            System.out.println("Password: ");
            String password = mykb.nextLine();
            if (password=="Dublin"){
                System.out.println("Welcome CCT Administrator");
            }
        }else{
            System.out.println("Welcome Student "+ userName);
        }
    }
    
    
    
}
