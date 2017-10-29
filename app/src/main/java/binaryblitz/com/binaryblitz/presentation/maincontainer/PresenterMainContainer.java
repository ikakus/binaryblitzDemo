package binaryblitz.com.binaryblitz.presentation.maincontainer;

import binaryblitz.com.binaryblitz.UserInteractionBus;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.maincontainer.interfaces.IMainContainerView;

/**
 * Created by ikakus on 10/27/17.
 */

class PresenterMainContainer implements Presenter<IMainContainerView>,UserInteractionBus.IUserInteractionSubscriber {

    private final UserInteractionBus mBus;
    private IMainContainerView mView;
    private boolean mIsRetained = false;

    public PresenterMainContainer(UserInteractionBus userInteractionBus) {
        mBus = userInteractionBus;
        mBus.addSubscriber(this);
    }

    @Override
    public void onViewAttached(IMainContainerView view) {
        mView = view;
        if(!mIsRetained) {
            mView.setUserList();
        }
        mIsRetained = true;
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {
        mIsRetained = false;
    }

    public void onCreateUserClick() {
        mView.showCreateUser();
    }

    @Override
    public void onUserEdit(UserModel userModel) {
        mView.showUserEdit(userModel);
    }
}
