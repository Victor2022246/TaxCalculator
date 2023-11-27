/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author victor pc
 */
public abstract class Database {
     //java database connector:mysql (specifies the protocol and the host)
    //The base URL For connecting to the MySQL Database
    protected final static String DB_BASE_URL= "jdbc:mysql://localhost";
    //Username to be used for connecting to the MySQL database
    protected final static String USER = "ooc2023";
    //The password to be used for connecting to the MySQL DB
    protected final static  String PASSWORD= "ooc2023";
    //Declaring the database's name
    protected final static String DB_NAME = "taxation";
    //A table name that will be use to store employee Data
    protected final static String TABLE_NAME= "employeeData";
   
    //jdbc:mysql://localhost/taxation
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
}

