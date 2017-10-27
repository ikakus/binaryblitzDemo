package binaryblitz.com.binaryblitz.presentation.maincontainer;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.di.modules.AppModule;


/**
 * Created by ikakus on 10/27/17.
 */

public class LoaderMainContainer extends Loader<PresenterMainContainer> {
    @Inject
    PresenterMainContainer mPresenter;
    private ComponentMainContainer mComponentMainContainer;

    public LoaderMainContainer(Context context) {
        super(context);
        mComponentMainContainer = DaggerComponentMainContainer.builder()
                .moduleMainContainer(new ModuleMainContainer())
                .appModule(new AppModule(getContext()))
                .build();
        mComponentMainContainer.inject(this);
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
