/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sande
 * Will carry most of the prompts we will use on our program
 * So we can make our main method cleaner
 */
public class Prompt {
    
    //Declaring possible variables
    private String userName;
    private String password;
    private int typeOfUser;
    //Declaring an Array List, where the user's will be stored
    private ArrayList<String> usersArray = new ArrayList<>();
    DatabaseReader dbReader = new DatabaseReader();
    Admin adm = new Admin();  
    //Adding scanner to get users input
    Scanner mykb = new Scanner(System.in); 
    /**
     * Displays the Welcome message
     */
    public void Welcome(){
        //Displaying welcome message
        System.out.println("Hi!! Welcome to the TAX calculator!\n"
                + "Please, provide your credentials!\n"
                + "Are you an Administrator, User or would you like to Register?\n"
                + "1.Administrator\n"
                + "2.User\n"
                + "3.Register");      
    }  
    /**
     * Will get user option from previous display
     * @throws SQLException
     * @throws Exception 
     */
    public void UserValidation() throws SQLException, Exception{
        //Getting what user inputs on the keyboard
            int typeOfUser = mykb.nextInt();
            //To be sure that the newLine character is consumed, a nextLine method is added.
            mykb.nextLine();       
            //Starting the Switch statement
        switch (typeOfUser) {
            /**
             * Will receive user's input for Admin credentials
             * Return true and grants login if the right credentials are inputted, false and ask again for credentials if otherwise
             */
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
                adm.adminMenu();
                break;
                
                /**
                 * Will receive Regular User credentials and if matches within our database, will grant access
                 * Return True and grant access if right credentials, false otherwise
                 */
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
                //Checking if provided username and password existin in the database
                //Calling our dbreader method
                if(dbReader.checkUserCredentials(userName, password)){
                    System.out.println("Login Successful!");//output login successfull
                     System.out.println("------------------------------------------");
                    RegularUser regularUser = new RegularUser(userName, password);//Instiating RegularUser class
                    regularUser.viewDetails();//Calling method that will display user's menu
                    regularUser.regularUserInfo();//Calling method that will edit the information the user decides
                    validCredentials = true;//Will stop loop if credentials are true
                }else{                   
                    System.out.println("Invalid credentials. Please try again!");//Case credentials are not found on our DB
                }
                }
                break;              
                /**
                 * Last case, will receive new Users data and write in our db
                 */
            case 3:
                //Boolean in case password does not match.
                boolean passwordMatches = false;
                
                //Prompt asking for user's credentials
                System.out.println("Welcome User. Please sign up:");
                System.out.println("Frst, enter your USERNAME");
                //Storing user's username
                String userStudent = mykb.nextLine();
                String passwordStudent = "";//declaring so I can use on my new employee
                //While passwordmatches not true(true in this case)
                //Keep asking for password, until both matches
                while(!passwordMatches){
                //Prompt requestin password
                System.out.println("Now enter your PASSWORD:");
                //Collecting password
                passwordStudent = mykb.nextLine();
                //Adding any new users into our array
                usersArray.add(userStudent);
                //Asking to input password again
                System.out.println("Please enter your password again:");
                //Collecting second password's input
                String passwordStudent2 = mykb.nextLine();
                //If both passwords matches
                if(passwordStudent.equals(passwordStudent2)){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Welcome " + userStudent + "! You are now Registered!\n"
                            + "Your Credentials and Details have been added onto our DataBase.");
                    System.out.println("-------------------------------------------------");
                    passwordMatches=true;
                }else{
                    //In case both dont match, user will have to type again
                    System.out.println("Your passwords don't match. Please try again!");
                }
                }                  
                    //Asking for his name. This will be updated on the table
                    System.out.println("Now please Insert your Name: ");
                    String newName = mykb.nextLine();//Receiving input
                    newName = newName.trim();//Trim unnecessary spaces
                    
                    System.out.println("Now please insert your surname: ");//Asking for surname
                    String newSurname = mykb.nextLine();//Collectting surname
                    newSurname = newSurname.trim();//Removing unnecessary spaces
                    
                    System.out.println("Now please insert your Gross Salary: ");//Asking for GrossSalary
                    double grossSalaryUser = mykb.nextFloat();//Receiving Input
                    mykb.nextLine();//Just consumming the input request 
                    
                    System.out.println("Now your TAX Credit:");//Asking for Tax credit
                    double taxCreditUser = mykb.nextFloat();//Collecting input
                    mykb.nextLine();//Consuming the input request
                    //Creating a new Employee with the parameters needed in our DB
                    Employee newEmp = new Employee(newName, newSurname, grossSalaryUser, taxCreditUser, userStudent, passwordStudent);//creating a new object of this new Empoyee                           
                    //Collecting last employee ID information from our Reader method
                    int lastEmployeeID = dbReader.getLastEmployeeID();
                    newEmp.setEmployeeID(lastEmployeeID+1);//Setting the new employee with lastID+1
                    DatabaseWriter dbw = new DatabaseWriter(); //Initialiazing the Writer 
                    dbw.addEmployee(newEmp);//Adding into our table(Writer)
                    //Outputting the salary method (table informations)
                    System.out.println(newEmp.Salary());
                    //Instantiating our RegularUser class with the paramenters from this newEmp
                    RegularUser regularUser = new RegularUser(userStudent, passwordStudent);
                    regularUser.regularUserInfo();//calling method that will ask what user wants to change
                          
                break;
            default:
                //Last case, user does not insert 1 or 2.
                System.out.println("Please enter the numbers 1 or 3 which reffers to your rype of user!");
                break;
        }
        }  
}