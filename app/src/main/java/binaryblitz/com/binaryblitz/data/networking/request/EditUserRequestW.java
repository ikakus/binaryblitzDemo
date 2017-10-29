package binaryblitz.com.binaryblitz.data.networking.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikakus on 10/28/17.
 */

public class EditUserRequestW {
    @SerializedName("user")
    @Expose
    private UserModelP user;

    public void setUser(UserModelP user) {
        this.user = user;
    }
}
