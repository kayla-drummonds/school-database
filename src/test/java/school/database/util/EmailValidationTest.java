package school.database.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class EmailValidationTest {

    /*
     * @ParameterizedTest
     * 
     * @ValueSource(strings = {"", "mickeysymonegmail.com",
     * "mickeysymone@gmail.com", "mickeysymone@gmail.co"}) public void
     * isEmailValidTest(String string) { EmailValidation ev = new EmailValidation();
     * Assertions.assertTrue(ev.isValidEmail(string));
     * 
     * }
     */
    
    @ParameterizedTest
    @ValueSource(strings = {"555-666-666", "", "12345678910", "1", " "})
    public void isPhoneNotValidTest(String phone) {
	Assertions.assertFalse(EmailValidation.isValidPhoneNumber(phone));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"544-666-6666", "548.333.4444", "123456789", "123 333 5969", "556890784"})
    public void isPhoneValidTest(String phone) {
	Assertions.assertTrue(EmailValidation.isValidPhoneNumber(phone));
    }
    
    
}
