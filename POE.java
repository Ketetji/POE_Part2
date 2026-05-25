/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import java.util.Scanner;
/**
 *
 * @author ketet
 */
public class POE {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        String phoneNumber = "";
        String firstName = "";  
        String lastName = ""; 
        int select;
        int flag = 0;
        
        System.out.println("Please select: \nRegistration(0)\nLogin(1)");
        select = scanner.nextInt();
        
        while (flag == 0) {
            if (select == 0) {
                // Registration
                System.out.println("Welcome to Account Registration");
                System.out.print("Please enter your first name: ");
                firstName = scanner.next();
                System.out.print("Please enter your last name: ");
                lastName = scanner.next();
                System.out.print("Please enter your username: ");
                username = scanner.next();
                System.out.print("Please enter your password: ");
                password = scanner.next();
                System.out.print("Please enter your phone number: ");
                phoneNumber = scanner.next();
                
                // Validate
                String result = validate(username, password, phoneNumber);
                if (result != null) {
                    System.out.println("Registration failed: " + result);
                    System.out.println("Please try again");
                } else {
                    System.out.println("Registration successful!");
                    select = 1; // move to login
                }
            } else if (select == 1) {
                // Login
                System.out.println("Welcome to Login");
                System.out.print("Please enter your username: ");
                String loginUsername = scanner.next();
                System.out.print("Please enter your password: ");
                String loginPassword = scanner.next();
                
                String loginResult = login(username, password, loginUsername, loginPassword);
                if (loginResult != null) {
                    System.out.println("Login failed: " + loginResult);
                    System.out.println("Please try again");
                } else {
    System.out.println("Login successful! Welcome back, " + firstName + " " + lastName + "!");
    flag = 1; // exit loop

    
    System.out.println("\n=== MESSAGE MENU ===");
    scanner.nextLine();

    System.out.print("Enter recipient phone number: ");
    String recipient = scanner.nextLine();

    System.out.print("Enter your message text: ");
    String messageText = scanner.nextLine();

    int messageNumber = 1;   
    int maxMessages = 100;   

    Message1 msg = new Message1(messageNumber, recipient, messageText, maxMessages);

    // Check recipient phone
    System.out.println(msg.checkRecipientCell());

    // Check message length
    System.out.println(msg.checkMessageLength());

    // Show generated ID and hash
    System.out.println("Generated Message ID: " + msg.getMessageID());
    System.out.println("Generated Message Hash: " + msg.createMessageHash());

    try {
        // Ask user to send/store/disregard
        String sendResult = msg.sentMessage();
        System.out.println(sendResult);

        // Show all sent messages
        System.out.println("\nAll sent messages so far:");
        System.out.println(Message1.getAllSentMessages());
    } catch (Exception e) {
        System.out.println("An error occurred while sending/storing the message: " + e.getMessage());
    }


                }
            }
        }
    }
    
    // Validation for registration
    public static String validate(String username, String password, String phoneNumber) {
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter.";
        }
        if (!password.matches(".*[0-9].*")) {
            return "Password must contain at least one number.";
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return "Password must contain at least one special character.";
        }
        if (!phoneNumber.matches("\\+27[0-9]{9}")) {
            return "Phone number must start with +27 and be followed by 9 digits (e.g. +27825643729).";
        }
        return null;
    }
    
    // Login validation
    public static String login(String regUsername, String regPassword, String loginUsername, String loginPassword) {
        if (!loginUsername.equals(regUsername)) {
            return "Username not found.";
        }
        if (!loginPassword.equals(regPassword)) {
            return "Incorrect password.";
        }
        return null;
   }
}
     
