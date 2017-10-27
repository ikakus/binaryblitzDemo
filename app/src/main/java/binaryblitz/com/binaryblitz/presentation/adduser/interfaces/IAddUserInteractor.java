package binaryblitz.com.binaryblitz.presentation.adduser.interfaces;

import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.networking.request.UserModelP;

/**
 * Created by ikakus on 10/27/17.
 */

public interface IAddUserInteractor {
    void addUser(UserAddedListener listener, UserModelP userModelP);

    interface UserAddedListener{
        void onError(String error);
        void onSuccess(BaseResponse userModels);
    }
}
