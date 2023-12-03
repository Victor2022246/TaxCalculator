/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static taxcalculator.Employee.getCurrentID;

/**
 *
 * @author sande
 */
//Creating prompt which will ask for User's input
public class Prompt {
    
    //Declaring possible variables
    private String userName;
    private String password;
    private int typeOfUser;
    //Declaring an Array List, where the user's will be stored
    private ArrayList<String> usersArray = new ArrayList<>();
    DatabaseReader dbReader = new DatabaseReader();
    

    
    //Adding scanner to get users input
    Scanner mykb = new Scanner(System.in);
    
    //Method that will display the welcome message 
    public void Welcome(){
        //Displaying welcome message
        System.out.println("Hi!! Welcome to the TAX calculator!\n"
                + "Please, provide your credentials!\n"
                + "Are you an Administrator, User or would you like to Register?\n"
                + "1.Administrator\n"
                + "2.User\n"
                + "3. Register");
        
    }  
    //Method that will validate the user credentials
    public void UserValidation() throws SQLException, Exception{
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
                //Case user inputs 2 for a User
                case 2:
                    //If the crentials are not valid
                boolean validCredentials = false;//Boolean to help woth the loop process
                //Loop the login section in case valid credentials is not true.
                while(!validCredentials){
                //Asking for username
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
                
                //Checking if provided username and password existin in the database
                if(dbReader.checkUserCredentials(userName, password)){
                    System.out.println("Login Successful!");
                }else{
                    
                    System.out.println("Invalid credentials. Please try again!");
                }
                }
                break;
            case 3:
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
                //Adding any new users into our array
                usersArray.add(userStudent);
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
                    //Asking for user's Username and password
                    System.out.println("Please insert your Username:");
                    String userNameUser = mykb.nextLine();
                    System.out.println("Now your password, please:");
                    String userPassword = mykb.nextLine();
                    //Asking for his name. This will be updated on the table
                    System.out.println("Now please Insert your Name: ");
                    String newName = mykb.nextLine();//Receiving input
                    newName = newName.trim();//Trim unnecessary spaces
                    
                    System.out.println("Now please insert your surname: ");//Asking for surname
                    String newSurname = mykb.nextLine();//Collectting surname
                    newSurname = newSurname.trim();//Removing unnecessary spaces
                    
                    System.out.println("Now please insert your Gross Salary: ");//Asking for GrossSalary
                    double grossSalaryUser = mykb.nextFloat();//Receiving Input
                    mykb.nextLine();//Just breaking the input so it won't crash 
                    
                    System.out.println("Now your TAX Credit:");
                    double taxCreditUser = mykb.nextFloat();
                    mykb.nextLine();
                    Employee newEmp = new Employee(newName, newSurname, grossSalaryUser, taxCreditUser, userNameUser, userPassword);//creating a new object of this new Empoyee                           
                  
              
                    int lastEmployeeID = dbReader.getLastEmployeeID();
                    newEmp.setEmployeeID(lastEmployeeID+1);
                    DatabaseWriter dbw = new DatabaseWriter(); //Initialiazing the Writer 
                    dbw.addEmployee(newEmp);//Adding into our table(Writer)
                    
                    System.out.println(newEmp.Salary());
                }
                break;
            default:
                //Last case, user does not insert 1 or 2.
                System.out.println("Please enter the numbers 1 or 2 which reffers to your rype of user!");
                break;       
        }
        }
    //Method to get the Array of userNames
    public ArrayList<String> getUsersArray(){
        return usersArray;
    }
    
}