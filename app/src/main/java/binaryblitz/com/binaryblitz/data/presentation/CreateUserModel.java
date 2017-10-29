package binaryblitz.com.binaryblitz.data.presentation;

/**
 * Created by ikakus on 10/28/17.
 */

public class CreateUserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUrl;

    public CreateUserModel(String firstName, String lastName, String email, String avatarUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
