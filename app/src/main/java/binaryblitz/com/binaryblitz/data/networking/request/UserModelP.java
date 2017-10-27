package binaryblitz.com.binaryblitz.data.networking.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserModelP {
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("avatar_url")
    @Expose
    public String avatarUrl;
}
