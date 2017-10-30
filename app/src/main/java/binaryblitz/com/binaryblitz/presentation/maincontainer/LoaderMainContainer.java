package binaryblitz.com.binaryblitz.presentation.maincontainer;

import android.content.Context;
import android.support.v4.content.Loader;

import javax.inject.Inject;

import binaryblitz.com.binaryblitz.App;
import binaryblitz.com.binaryblitz.presentation.edituser.ModuleEditUser;


/**
 * Created by ikakus on 10/27/17.
 */

public class LoaderMainContainer extends Loader<PresenterMainContainer> {
    @Inject
    PresenterMainContainer mPresenter;
    private ComponentMainContainer mComponentMainContainer;

    public LoaderMainContainer(Context context) {
        super(context);
        mComponentMainContainer  = App.getAppComponent().plusMainContainerComponent(new ModuleMainContainer());
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
