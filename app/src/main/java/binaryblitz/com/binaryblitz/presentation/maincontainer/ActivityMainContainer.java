package binaryblitz.com.binaryblitz.presentation.maincontainer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.presentation.maincontainer.interfaces.IMainContainerView;
import binaryblitz.com.binaryblitz.presentation.userlist.UserListViewFragment;


public class ActivityMainContainer extends AppCompatActivity implements IMainContainerView, LoaderManager.LoaderCallbacks<PresenterMainContainer> {
    private boolean mTwoPane;
    private PresenterMainContainer mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (findViewById(R.id.detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportLoaderManager().initLoader(0, null, this);
    }

    private void setListFragment() {
        UserListViewFragment fragment = new UserListViewFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.user_list_container, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void setUserList() {
        if(mTwoPane){

        }else {
            setListFragment();
        }
    }

    @Override
    public Loader<PresenterMainContainer> onCreateLoader(int id, Bundle args) {
        return new LoaderMainContainer(this);
    }

    @Override
    public void onLoadFinished(Loader<PresenterMainContainer> loader, PresenterMainContainer presenter) {
        mPresenter = presenter;
        mPresenter.onViewAttached(this);
    }

    @Override
    public void onLoaderReset(Loader<PresenterMainContainer> loader) {
        mPresenter = null;
    }
}
