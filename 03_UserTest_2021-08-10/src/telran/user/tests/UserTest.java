package telran.user.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.user.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    final String password = "J!qq5h8h5v";
    final String email = "rasalex@gmail.com";
    User user;

    @BeforeEach
    void setUp() throws Exception {
        user = new User(email, password);
    }

    @Test
    void testValidPassword() {
        assertEquals(password, user.getPassword());

    }

    @Test
    void testPasswordLength() {
        String wrongPassword = "J!qq5h8";
        user.setPassword(wrongPassword);
        assertNotEquals(wrongPassword, user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordLowCaseSymbols() {
        String wrongPassword = "J!QQ5H8";
        user.setPassword(wrongPassword);
        assertNotEquals(wrongPassword, user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordUpperCaseSymbols() {
        String wrongPassword = "j!qq5h8";
        user.setPassword(wrongPassword);
        assertNotEquals(wrongPassword, user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordDigits() {
        String wrongPassword = "qwery!@#$%";
        user.setPassword(wrongPassword);
        assertNotEquals(wrongPassword, user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordSpecSymbols() {
        String wrongPassword = "12345QweQer";
        user.setPassword(wrongPassword);
        assertNotEquals(wrongPassword, user.getPassword());
        assertEquals(password, user.getPassword());
    }
    @Test
    void testCorrectEmail() {
        String expectedMail = "RasAlex@gmail.com";
        user.setEmail("RasAlex@gmail.com");
        assertEquals(expectedMail, user.getEmail());
    }
    @Test
    void testEmailWithoutAt() {
        user.setEmail("RasAlex_gmail.com");
        assertEquals(email, user.getEmail());
        }
    @Test
    void testEmailWitDoubleAt() {
        user.setEmail("RasAlex@gmail@yandex.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testEmailDotAfterAt() {
        user.setEmail("RasAlex@gmailcom");
        assertEquals(email, user.getEmail());
    }
    @Test
    void testEmailLastDot() {
        user.setEmail("RasAlex@gmailcom.");
        assertEquals(email, user.getEmail());
        user.setEmail("RasAlex@gmailco.m");
        assertEquals(email, user.getEmail());
    }
    @Test
    void testEmailIncorrectSymbols() {
        user.setEmail("Ras!Alex@gmailcom.");
        assertEquals(email, user.getEmail());
        user.setEmail("Ra#sAlex@gmailco.m");
        assertEquals(email, user.getEmail());
    }
}