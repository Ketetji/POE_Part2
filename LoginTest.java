/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poe.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Username tests
    @Test
    public void testUsernameTooLong() {
        String result = Login.validate("katiey_moodley", "Password1!", "+27826745374");
        assertEquals("Username must be 5 characters or fewer.", result);
    }

    @Test
    public void testUsernameMissingUnderscore() {
        String result = Login.validate("Neo2", "Password1!", "+27657849303");
        assertEquals("Username must contain underscore (_).", result);
    }

    @Test
    public void testUsernameValid() {
        String result = Login.validate("Ne_1", "Password1!", "+27756489345");
        assertNull(result);
    }

    // Password tests
    @Test
    public void testPasswordTooShort() {
        String result = Login.validate("di_1", "Pass1!", "+27563789765");
        assertEquals("Password must be at least 8 characters long.", result);
    }

    @Test
    public void testPasswordMissingUppercase() {
        String result = Login.validate("di_1", "password1!", "+27563789765");
        assertEquals("Password must contain at least one uppercase letter.", result);
    }

    @Test
    public void testPasswordMissingNumber() {
        String result = Login.validate("di_1", "Password!", "+27563789765");
        assertEquals("Password must contain at least one number.", result);
    }

    @Test
    public void testPasswordMissingSpecialCharacter() {
        String result = Login.validate("di_1", "Password1", "+27563789765");
        assertEquals("Password must contain at least one special character.", result);
    }

    @Test
    public void testPasswordValid() {
        String result = Login.validate("di_1", "Password1!", "+27563789765");
        assertNull(result);
    }

    // Phone number tests
    @Test
    public void testPhoneNumberMissingCountryCode() {
        String result = Login.validate("di_1", "Password1!", "7563789765");
        assertEquals("Phone number must start with +27 and be followed by 9 digits (e.g. +27674836475).", result);
    }

    @Test
    public void testPhoneNumberTooShort() {
        String result = Login.validate("di_1", "Password1!", "+27123");
        assertEquals("Phone number must start with +27 and be followed by 9 digits (e.g. +27674836475).", result);
    }

    @Test
    public void testPhoneNumberTooLong() {
        String result = Login.validate("di_1", "Password1!", "+271234567890123");
        assertEquals("Phone number must start with +27 and be followed by 9 digits (e.g. +27674836475).", result);
    }

    @Test
    public void testPhoneNumberValid() {
        String result = Login.validate("di_1", "Password1!", "+27825643729");
        assertNull(result);
    }

    }
