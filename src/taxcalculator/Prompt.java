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
    
    //public String userName;
    public int typeOfUser;
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
            mykb.nextLine();
        switch (typeOfUser) {
            case 1:
                boolean isAdmin = false;
                
                while(!isAdmin){
                System.out.println("Please enter your credentials.");
                System.out.println("USERNAME:");
                String userName = mykb.nextLine();
                
                System.out.println("PASSWORD:");
                String password = mykb.nextLine();
                userName = userName.toUpperCase();
                if("CCT".equals(userName)&&"Dublin".equalsIgnoreCase(password)){
                    System.out.println("Welcomee CCT Adminsitrator!!!");
                    isAdmin=true;
                }else{
                    System.out.println("Wrong Credentials. Please try again!");
                }
                }
                break;
            case 2:
                
                boolean passwordMatches = false;
                
                
                System.out.println("Welcome User. Please sign up:");
                System.out.println("Frst, enter your USERNAME");
                
                String userStudent = mykb.nextLine();
                
                while(!passwordMatches){
                System.out.println("Now enter your PASSWORD:");
                
                String passwordStudent = mykb.nextLine();
                
                System.out.println("Please enter your password again:");
                
                String passwordStudent2 = mykb.nextLine();
                
                if(passwordStudent.equals(passwordStudent2)){
                    System.out.println("WElcome " + userStudent + "You are now signed up!");
                    passwordMatches=true;
                }else{
                    System.out.println("Your passwords don't match. Please try again!");
                }
                }
                break;
            default:
                System.out.println("Please enter the numbers 1 or 2 which reffers to your rype of user!");
                break;       
        }
        }
}