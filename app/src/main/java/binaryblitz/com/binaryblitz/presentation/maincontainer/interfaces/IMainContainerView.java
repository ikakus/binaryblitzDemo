package binaryblitz.com.binaryblitz.presentation.maincontainer.interfaces;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;

/**
 * Created by ikakus on 10/27/17.
 */

public interface IMainContainerView {
    void setUserList();

    void showCreateUser();

    void showUserEdit(UserModel userModel);
}
