package binaryblitz.com.binaryblitz.presentation.createuser.interfaces;

/**
 * Created by ikakus on 10/27/17.
 */

public interface ICreateUserView {
    String getFirstName();

    void setFirstName(String fistName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    String getAvatarUrl();

    void showErrorFirstName(String errorMessage);

    void showErrorLastName(String errorMessage);

    void showErrorEmail(String errorMessage);

    void showError(String error);

    void close();
}
