package binaryblitz.com.binaryblitz.presentation.createuser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import binaryblitz.com.binaryblitz.utils.UserFieldsValidator;

import static org.junit.Assert.assertEquals;

/**
 * Created by ikakus on 10/28/17.
 */
@RunWith(RobolectricTestRunner.class)
public class UserFieldsValidatorTest {
    @Test
    public void email_isCorrect() throws Exception {
        boolean result = UserFieldsValidator.validateEmail("asd@asd.com");
        assertEquals(true, result);
    }

    @Test
    public void email_isNotCorrect_noAt() throws Exception {
        boolean result = UserFieldsValidator.validateEmail("asdasd.com");
        assertEquals(false, result);
    }

    @Test
    public void email_isNotCorrect_noDotCom() throws Exception {
        boolean result = UserFieldsValidator.validateEmail("asd@asd");
        assertEquals(false, result);
    }

    @Test
    public void email_isNotCorrect_noText() throws Exception {
        boolean result = UserFieldsValidator.validateEmail("");
        assertEquals(false, result);
    }
}