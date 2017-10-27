package binaryblitz.com.binaryblitz.presentation.userlist;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.di.modules.AppModule;


/**
 * Loader for presenter surviving rotation
 */

public class LoaderUserList extends Loader<PresenterUserList> {
    @Inject
    PresenterUserList mPresenter;
    private ComponentUserList mComponentUserList;
    public LoaderUserList(Context context) {
        super(context);
        mComponentUserList = DaggerComponentUserList.builder()
                .moduleUserList(new ModuleUserList())
                .appModule(new AppModule(getContext()))
                .build();
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
