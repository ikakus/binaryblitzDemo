package binaryblitz.com.binaryblitz.presentation.adduser.interfaces;

import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.presentation.CreateUserModel;

/**
 * Created by ikakus on 10/27/17.
 */

public interface ICreateUserInteractor {
    void addUser(CreateUserModel createUserModel, UserAddedListener listener);

    interface UserAddedListener {
        void onError(String error);

        void onSuccess(BaseResponse userModels);
    }
}
