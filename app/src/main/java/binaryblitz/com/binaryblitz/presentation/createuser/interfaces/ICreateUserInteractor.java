package binaryblitz.com.binaryblitz.presentation.createuser.interfaces;

import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;
import binaryblitz.com.binaryblitz.data.presentation.CreateUserModel;

/**
 * Created by ikakus on 10/27/17.
 */

public interface ICreateUserInteractor {
    void addUser(CreateUserModel createUserModel, UserAddedListener listener);

    interface UserAddedListener {
        void onError(String error);

        void onSuccess(UserModelR userModels);
    }
}
