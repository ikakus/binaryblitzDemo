package binaryblitz.com.binaryblitz.presentation.createuser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

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
    public void email_isNotCorrect() throws Exception {
        boolean result = UserFieldsValidator.validateEmail("asdasd.com");
        assertEquals(false, result);
    }

    @Test
    public void email_isNotCorrect_2() throws Exception {
        boolean result = UserFieldsValidator.validateEmail("asd@asd");
        assertEquals(false, result);
    }
}