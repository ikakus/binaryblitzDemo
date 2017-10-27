package binaryblitz.com.binaryblitz.presentation.maincontainer;

import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.maincontainer.interfaces.IMainContainerView;

/**
 * Created by ikakus on 10/27/17.
 */

class PresenterMainContainer implements Presenter<IMainContainerView> {

    private IMainContainerView mView;
    private boolean mIsRetained = false;

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
}
