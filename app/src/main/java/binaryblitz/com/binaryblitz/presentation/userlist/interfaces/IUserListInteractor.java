package binaryblitz.com.binaryblitz.presentation.userlist.interfaces;

import java.util.List;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;

/**
 * Created by ikakus on 10/26/17.
 */

public interface IUserListInteractor {
    void getUsers(UsersLoadedListener listener);

    interface UsersLoadedListener{
        void onError(String error);
        void onSuccess(List<UserModel> restaurants);
    }
}
