package binaryblitz.com.binaryblitz.presentation.userlist;

import java.util.List;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IUserListInteractor;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IViewUserList;

/**
 * Created by ikakus on 10/25/17.
 */

public class PresenterUserList implements Presenter<IViewUserList>,IUserListInteractor.UsersLoadedListener, IViewUserList.OnUserItemClickListener {
    private final IUserListInteractor mInteractor;
    private IViewUserList mView;
    private List<UserModel> mUserMoodels;

    public PresenterUserList(IUserListInteractor iUserListInteractor) {
        mInteractor = iUserListInteractor;
    }

    @Override
    public void onViewAttached(IViewUserList view) {
        mView = view;
        if(mUserMoodels == null) {
            mInteractor.getUsers(this);
        }else {
            onSuccess(mUserMoodels);
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
        mView.showText(error);
    }

    @Override
    public void onSuccess(List<UserModel> userModels) {
        mUserMoodels = userModels;
        mView.fillUsers(userModels);
    }

    @Override
    public void onUserItemClicked(int userId) {
        mView.showText("User id:" + userId);
    }
}
