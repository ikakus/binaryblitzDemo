package binaryblitz.com.binaryblitz.data.presentation;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Date;

import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserModel implements Parcelable, Comparable<UserModel> {
    public static final String USER_MODEL= "user_model";

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUrl;
    private Date createdAt;
    private Date updatedAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
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
        dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
        dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
    }

    protected UserModel(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.email = in.readString();
        this.avatarUrl = in.readString();
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        long tmpUpdatedAt = in.readLong();
        this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int compareTo(@NonNull UserModel userModel) {
        return getUpdatedAt().compareTo(userModel.getUpdatedAt());
    }
}
