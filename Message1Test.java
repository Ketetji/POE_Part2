/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
 
import com.mycompany.poe.Message1;
import com.mycompany.poe.Message1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Message1Test {

    // Message length tests
    @Test
    public void testMessageTooLong() {
        String longMessage = "a".repeat(251);
        Message1 msg = new Message1(1, "+27754638745", longMessage, 10);
        
    }

    @Test
    public void testMessageValidLength() {
        Message1 msg = new Message1(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?", 10);
        assertEquals("Message ready to send.", msg.checkMessageLength());
    
    }

    // Recipient tests
    @Test
    public void testRecipientValid() {
        Message1 msg = new Message1(1, "+27564785926", "Hi Mike, can you join us for dinner tonight?", 10);
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testRecipientInvalid() {
        Message1 msg = new Message1(1, "08745637289403", "Hi Keegan, did you receive the payment?", 10);
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", 
                     msg.checkRecipientCell());
    }

    // Message hash test
    @Test
    public void testMessageHash() {
        Message1 msg = new Message1(1, "+27654789364", "Hi Mike, can you join us for dinner tonight?", 10);
        String hash = msg.createMessageHash();
        // Example check: ensure hash contains transformed text
        assertTrue(hash.contains("HI") || hash.contains("TONIGHT"));
    }

    // Message ID test
    @Test
    public void testMessageID() {
        Message1 msg = new Message1(42, "+27825643729", "Test message", 10);
        assertTrue(msg.getMessageID().length() == 10);
    }
} 

    
