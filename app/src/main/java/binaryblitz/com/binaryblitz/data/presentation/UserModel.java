package binaryblitz.com.binaryblitz.data.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserModel implements Parcelable {
    public static final String USER_MODEL= "user_model";

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.email);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
    }

    protected UserModel(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.email = in.readString();
        this.avatarUrl = in.readString();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
