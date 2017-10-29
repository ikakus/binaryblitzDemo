package binaryblitz.com.binaryblitz.presentation.edituser.interfaces;

import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.presentation.EditUserModel;

/**
 * Created by ikakus on 10/27/17.
 */

public interface IEditUserInteractor {
    void editUser(EditUserModel createUserModel, UserEditListener listener);

    interface UserEditListener {
        void onError(String error);

        void onSuccess(BaseResponse userModels);
    }
}
