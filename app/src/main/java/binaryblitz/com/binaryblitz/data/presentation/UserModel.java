package binaryblitz.com.binaryblitz.data.presentation;

import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUrl;
    private String createdAt;
    private String updatedAt;

    public UserModel(UserModelR userModelR) {
        this.id = userModelR.getId();
        this.firstName = userModelR.getFirstName();
        this.lastName = userModelR.getLastName();
        this.email = userModelR.getEmail();
        this.avatarUrl = userModelR.getAvatarUrl();
        this.createdAt = userModelR.getCreatedAt();
        this.updatedAt = userModelR.getUpdatedAt();
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

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
