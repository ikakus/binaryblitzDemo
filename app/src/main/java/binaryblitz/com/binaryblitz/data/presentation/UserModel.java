package binaryblitz.com.binaryblitz.data.presentation;

import binaryblitz.com.binaryblitz.data.networking.UserModelR;

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
        this.id = userModelR.id;
        this.firstName = userModelR.firstName;
        this.lastName = userModelR.lastName;
        this.email = userModelR.email;
        this.avatarUrl = userModelR.avatarUrl;
        this.createdAt = userModelR.createdAt;
        this.updatedAt = userModelR.updatedAt;
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
