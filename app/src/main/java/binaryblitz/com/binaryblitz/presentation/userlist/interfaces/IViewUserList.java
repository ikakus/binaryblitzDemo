package binaryblitz.com.binaryblitz.presentation.userlist.interfaces;

import java.util.List;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;

/**
 * Created by ikakus on 10/25/17.
 */

public interface IViewUserList {
    void showText(String s);

    void fillUsers(List<UserModel> userModels);

    void hideLoading();

    void showLoading();

    interface OnUserItemClickListener {
        void onUserItemClicked(UserModel userId);
    }
}
