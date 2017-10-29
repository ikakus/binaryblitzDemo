package binaryblitz.com.binaryblitz.data.networking.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserModelR {
    @SerializedName("id")
    @Expose
    private Integer id;
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
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose
    private Date updatedAt;

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
}
