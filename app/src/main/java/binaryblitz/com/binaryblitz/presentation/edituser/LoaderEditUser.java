package binaryblitz.com.binaryblitz.presentation.edituser;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.App;

/**
 * Created by ikakus on 10/27/17.
 */

public class LoaderEditUser extends Loader<PresenterEditUser> {
    @Inject
    PresenterEditUser mPresenter;
    private ComponentEditUser mComponentEditUser;

    public LoaderEditUser(Context context) {
        super(context);
        mComponentEditUser = App.getAppComponent().plusEditUserComponent(new ModuleEditUser());
        mComponentEditUser.inject(this);
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
