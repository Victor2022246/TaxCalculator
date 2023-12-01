/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 *
 * @author sande
 */
public class Admin extends DatabaseReader {
    
    private String firstName;
    private String surName;
    private String age;

    public Admin(String firstName, String surName, String age) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    public void readAlldata(){
    
    DatabaseReader dbr = new DatabaseReader();
    
    
    
    }
    
}
