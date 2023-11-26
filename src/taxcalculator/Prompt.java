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
    
    //Declaring possible variables
    public String userName;
    public String password;
    public int typeOfUser;
  
    

    
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
    //Method that will validate the user credentials
    public void UserValidation(){
        //Getting what user inputs on the keyboard
            int typeOfUser = mykb.nextInt();
            //To be sure that the newLine character is consumed, a nextLine method is added.
            mykb.nextLine();
            
            //Starting the Switch statement
        switch (typeOfUser) {
            //User types number 1, he will input ADMins credentials
            case 1:
                //Declaring a boolean variable in case user is an Admin, to make our loop
                boolean isAdmin = false;
                //While isAdmin is not true(True in this case)
                while(!isAdmin){
                //Prompt asking for username
                System.out.println("Please enter your credentials.");
                System.out.println("USERNAME:");
                //Collecting user's input
                String userName = mykb.nextLine();
                //Asking for password
                System.out.println("PASSWORD:");
                //Collecting user's input
                String password = mykb.nextLine();
                //In case user types cct lower case it will be transffered to UpCase (TO avoid misspealings)
                userName = userName.toUpperCase();
                //If Statement if the userName and password matches with the Admin credentials
                if("CCT".equals(userName)&&"Dublin".equalsIgnoreCase(password)){
                    System.out.println("Welcomee CCT Adminsitrator!!!");
                    //This means isAmdin is true, all good!
                    isAdmin=true;
                }else{
                    //Or the username and password are wrong. User will have to type both again
                    //More secure to type both again than showing to the user which of them is wrong.
                    System.out.println("Wrong Credentials. Please try again!");
                }
                }
                break;
            case 2:
                //Boolea in case password does not match.
                boolean passwordMatches = false;
                
                //Prompt asking for user's credentials
                System.out.println("Welcome User. Please sign up:");
                System.out.println("Frst, enter your USERNAME");
                //Storing user's username
                String userStudent = mykb.nextLine();
                //While passwordmatches not true(true in this case)
                //Keep asking for password, until both matches
                while(!passwordMatches){
                    //Prompt requestin password
                System.out.println("Now enter your PASSWORD:");
                //Collecting password
                String passwordStudent = mykb.nextLine();
                //Asking to input password again
                System.out.println("Please enter your password again:");
                //Collecting second password's input
                String passwordStudent2 = mykb.nextLine();
                //If both passwords matche
                if(passwordStudent.equals(passwordStudent2)){
                    System.out.println("WElcome " + userStudent + "You are now signed up!");
                 
                    passwordMatches=true;
                }else{
                    //In case both dont match, user will have to type again
                    System.out.println("Your passwords don't match. Please try again!");
                }
                }
                break;
            default:
                //Last case, user doen not insert 1 or 2.
                System.out.println("Please enter the numbers 1 or 2 which reffers to your rype of user!");
                break;       
        }
        }
}