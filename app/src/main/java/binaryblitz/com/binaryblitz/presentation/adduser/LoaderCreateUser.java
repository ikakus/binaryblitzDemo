package binaryblitz.com.binaryblitz.presentation.adduser;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.di.modules.AppModule;

/**
 * Created by ikakus on 10/27/17.
 */

public class LoaderCreateUser extends Loader<PresenterCreateUser> {
    @Inject
    PresenterCreateUser mPresenter;
    private ComponentCreateUser mComponentCreateUser;
    public LoaderCreateUser(Context context) {
        super(context);
        mComponentCreateUser = DaggerComponentCreateUser.builder()
                .moduleCreateUser(new ModuleCreateUser())
                .appModule(new AppModule(getContext()))
                .build();
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
