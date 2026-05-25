/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author ketet
 */
public class Login {

    public static String validate(String katiey_moodley, String password1, String string) {
        return null;
    }

  
    private String firstName;
    private String lastName;
    private String cellNumber;
    private String Username;
    private String Password;
    
    //Validation method
    //checks if username entered meets the required format
    public boolean checkUsername(String Username) {
        return Username.contains("_") && Username.length()<=5;
    }
    
    public boolean checkPassword(String Password) {
        //This String ragex uses the pre entered restrictions to see if the data meets the required format
        String ragex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!_\\-*~]).{8,}$"; 
        return Password.matches(ragex);
    }
    public boolean checkCellPhoneNumber(String cellPhone) {
        String ragex = "^(\\+2710)[6-8][0-9]{8}$";
        return cellNumber.matches(ragex);
    }
    
    //Registration method
    public String registerUser(String Username, String Password, String cellNumber) {
        if (!checkUsername(Username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length";
        }
        if (!checkPassword(Password)) {
            return "Password is not correctly formatted; please insure that the oassword contains at least eight characters, a special letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cellphone number incorrectly formatted or does not contain international code.";
        }
        
        //If all "if" statements pass the me requirements, the data is valid
        this.Username = Username;
        this.Password = Password;
        this.cellNumber = cellNumber;
        return "Registration process complete, the username, Password, and Cell phone have been successfully captured";
    }
    
    //Login and authentication
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(Username) && enteredPassword.equals(Password);
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //Return a final message based on the loginUser boolean and check if it passes or fail
    public String returnLoginUser(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
}
    
    
