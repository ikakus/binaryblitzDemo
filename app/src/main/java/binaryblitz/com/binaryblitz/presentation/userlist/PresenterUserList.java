package binaryblitz.com.binaryblitz.presentation.userlist;

import java.util.List;

import binaryblitz.com.binaryblitz.UserInteractionBus;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IUserListInteractor;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IViewUserList;

/**
 * Created by ikakus on 10/25/17.
 */

public class PresenterUserList implements Presenter<IViewUserList>,IUserListInteractor.UsersLoadedListener, IViewUserList.OnUserItemClickListener {
    private final IUserListInteractor mInteractor;
    private final UserInteractionBus mBus;
    private IViewUserList mView;
    private List<UserModel> mUserModels;

    public PresenterUserList(IUserListInteractor iUserListInteractor, UserInteractionBus userInteractionBus) {
        mInteractor = iUserListInteractor;
        mBus = userInteractionBus;
    }

    @Override
    public void onViewAttached(IViewUserList view) {
        mView = view;
        if(mUserModels == null) {
            mView.showLoading();
            mInteractor.getUsers(this);
        }else {
            onSuccess(mUserModels);
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
        mView.hideLoading();
        mView.showText(error);
    }

    @Override
    public void onSuccess(List<UserModel> userModels) {
        mView.hideLoading();
        mUserModels = userModels;
        mView.fillUsers(userModels);
    }

    @Override
    public void onUserItemClicked(UserModel userModel) {
        mBus.onUserEditClick(userModel);
//        mView.showText("User id:" + userModel.getId());
    }

    public void reload(){
        mInteractor.getUsers(this);
    }
}
