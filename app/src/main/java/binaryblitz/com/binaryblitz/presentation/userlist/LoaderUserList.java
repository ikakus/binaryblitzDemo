package binaryblitz.com.binaryblitz.presentation.userlist;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.App;
import binaryblitz.com.binaryblitz.presentation.edituser.ModuleEditUser;


/**
 * Loader for presenter surviving rotation
 */

public class LoaderUserList extends Loader<PresenterUserList> {
    @Inject
    PresenterUserList mPresenter;
    private ComponentUserList mComponentUserList;

    public LoaderUserList(Context context) {
        super(context);
        mComponentUserList  = App.getAppComponent().plusUserListComponent(new ModuleUserList());
        mComponentUserList.inject(this);

    }

    @Override
    protected void onStartLoading() {
        deliverResult(mPresenter);
    }

    @Override
    protected void onReset() {
        mPresenter.onDestroyed();
        mPresenter = null;
    }
}
