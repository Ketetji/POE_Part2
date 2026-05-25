/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author ketet
 */
public class Message1 {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    private static int totalMessagesSent = 0;
    private static String[] sentMessages;
    private static int messageIndex = 0;
    
    //Constructor
    public Message1(int messageNumber, String recipient, String messageText, int maxMessages){
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
        if (sentMessages == null) {
            sentMessages = new String[maxMessages];
        }
    }

    
    //Getter
    public String getMessageID() {
        return messageID;
    }
    //Generate 10 digit ID
    private String generateMessageID(){
        Random rand = new Random();
        long id = (long) rand.nextInt(1000000000) + 1000000000;
        return String.valueOf(id);
    }
    //Check ID length
    public boolean checkMessageID(){
        return messageID.length() == 10;
    }
    //Check cell number
    public String checkRecipientCell(){
        if (!recipient.matches("\\+[0-9]{9,11}") && !recipient.matches("[0-9]{10}")){
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        return "Cell phone number successfully captured.";
    }
    //Create hash
    public String createMessageHash(){
        String[] words = messageText.trim().split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : "";
        String firstTwo = messageID.substring(0, 2);
        String hash = firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }
    //Check message length
    public String checkMessageLength() {
        if (messageText.length() > 250) {
            int excess = messageText.length() -250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";        
        }
        return "Message ready to send.";
    }   
        
        //Send, store or delete message
    public String sentMessage() throws IOException {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Choose an option:");
          System.out.println("1) Send Message");
          System.out.println("2) Disregard Message");
          System.out.println("3) Store Message to send later");
          int choice = scanner.nextInt();
          
           if (choice == 1) {
              sentMessages[messageIndex] = printMessage();
              messageIndex++;
              totalMessagesSent++;
              return "Message successfully sent.";
        } else if (choice == 2){
            return "Press 0 to delete the message.";
        } else if (choice == 3){
            storeMessage(messageID, messageHash, recipient, messageText);
            return "Message successfully stored.";
        } else {
            return "Invalid option.";
        }    
    }
    
    //Store message to JSON file
    public static void storeMessage(String messageID, String messageHash, String recipient, String messageText) throws IOException{
        String json = "{\n" +
                " \"messageID\": \"" + messageID + "\",\n" +
                " \"messageHash\": \"" + messageHash + "\",\n" +
                " \"recipient\": \"" + recipient + "\",\n" +
                " \"messageText\": \"" + messageText + "\",\n" +
                "}";
        
        try {
            java.io.FileWriter writer = new java.io.FileWriter("Message.json", true);
            writer.write(json + "\n");
            writer.close();
        } catch (Exception e){
            System.out.println("Error storing message: " + e.getMessage());
        }
    }
    
    //Print message in full
    public String printMessage(){
        return "Message ID: " + messageID + "\n" +
                "Message Hash: " + messageHash + "\n" +
                "Recipient: " + recipient + "\n" +
                "Message: " + messageText;
    }
    
    //Return total number of messages sent
    public int returnTotalMessages() {
        return totalMessagesSent;
    }
    
    // Return all messages sent
    public static String getAllSentMessages() {
        if (messageIndex == 0) {
            return "No messages sent yet.";
        }
        String result = "";
        for (int i = 0; i < messageIndex; i++) {
            result += sentMessages[i] + "\n-----------\n";
        }
        return result;
    }
}
