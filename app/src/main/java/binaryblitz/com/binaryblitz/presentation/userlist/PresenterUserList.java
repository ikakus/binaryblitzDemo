package binaryblitz.com.binaryblitz.presentation.userlist;

import java.util.List;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IUserListInteractor;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.ViewUserList;

/**
 * Created by ikakus on 10/25/17.
 */

public class PresenterUserList implements Presenter<ViewUserList>,IUserListInteractor.UsersLoadedListener {
    private final IUserListInteractor mInteractor;
    private ViewUserList mView;
    private List<UserModel> mUserMoodels;

    public PresenterUserList(IUserListInteractor iUserListInteractor) {
        mInteractor = iUserListInteractor;
    }

    @Override
    public void onViewAttached(ViewUserList view) {
        mView = view;
        if(mUserMoodels == null) {
            mInteractor.getUsers(this);
        }
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }

    @Override
    public void onError(String error) {
        mView.show(error);
    }

    @Override
    public void onSuccess(List<UserModel> userModels) {
        mUserMoodels = userModels;
        mView.show(mUserMoodels.get(0).getFirstName());

    }
}
