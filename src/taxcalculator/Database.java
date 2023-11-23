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
    final static String DB_BASE_URL= "jdbc:mysql://localhost";
    final static String USER = "ooc2023";
    final static  String PASSWORD= "ooc2023";
    protected final static String DB_NAME = "taxation";
    protected final static String TABLE_NAME= "employeeData";
   
    //jdbc:mysql://localhost/hospital
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
    
}

