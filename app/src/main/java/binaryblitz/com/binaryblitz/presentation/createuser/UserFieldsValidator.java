package binaryblitz.com.binaryblitz.presentation.createuser;

/**
 * Created by ikakus on 10/27/17.
 */

public class UserFieldsValidator {
    public static boolean validateEmail(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean validateTextField(String lastName) {
        return !lastName.isEmpty();
    }
}
