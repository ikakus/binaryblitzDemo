package binaryblitz.com.binaryblitz.data.presentation;

/**
 * Created by ikakus on 10/28/17.
 */

public class EditUserModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUrl;
    public EditUserModel(Integer id, String firstName, String lastName, String email, String avatarUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public Integer getId() {
        return id;
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
