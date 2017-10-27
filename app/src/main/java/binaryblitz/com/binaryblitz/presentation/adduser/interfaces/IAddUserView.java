package binaryblitz.com.binaryblitz.presentation.adduser.interfaces;

/**
 * Created by ikakus on 10/27/17.
 */

public interface IAddUserView {
    String getFirstName();
    String getLastName();
    String getEmail();
    String getAvatarUrl();

    void showErrorFirstName(String errorMessage);
    void showErrorLastName(String errorMessage);
    void showErrorEmail(String errorMessage);

    void close();
}
