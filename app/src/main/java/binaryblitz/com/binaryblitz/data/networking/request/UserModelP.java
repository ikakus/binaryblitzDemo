package binaryblitz.com.binaryblitz.data.networking.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import binaryblitz.com.binaryblitz.data.presentation.CreateUserModel;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserModelP {
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    public UserModelP(CreateUserModel createUserModel) {
        this.firstName = createUserModel.getFirstName();
        this.lastName = createUserModel.getLastName();
        this.email = createUserModel.getEmail();
        this.avatarUrl = createUserModel.getAvatarUrl();
    }
}
