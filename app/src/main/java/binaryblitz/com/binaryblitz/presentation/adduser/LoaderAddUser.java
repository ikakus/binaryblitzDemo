package binaryblitz.com.binaryblitz.presentation.adduser;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.di.modules.AppModule;

/**
 * Created by ikakus on 10/27/17.
 */

public class LoaderAddUser extends Loader<PresenterAddUser> {
    @Inject
    PresenterAddUser mPresenter;
    private ComponentAddUser mComponentAddUser;
    public LoaderAddUser(Context context) {
        super(context);
        mComponentAddUser = DaggerComponentAddUser.builder()
                .moduleAddUser(new ModuleAddUser())
                .appModule(new AppModule(getContext()))
                .build();
        mComponentAddUser.inject(this);
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
