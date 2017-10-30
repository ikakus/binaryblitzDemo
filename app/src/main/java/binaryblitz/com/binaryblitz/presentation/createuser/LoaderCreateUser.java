package binaryblitz.com.binaryblitz.presentation.createuser;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.App;

/**
 * Created by ikakus on 10/27/17.
 */

public class LoaderCreateUser extends Loader<PresenterCreateUser> {
    @Inject
    PresenterCreateUser mPresenter;
    private ComponentCreateUser mComponentCreateUser;

    public LoaderCreateUser(Context context) {
        super(context);
        mComponentCreateUser = App.getAppComponent().plusCreateUserComponent(new ModuleCreateUser());
        mComponentCreateUser.inject(this);
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
