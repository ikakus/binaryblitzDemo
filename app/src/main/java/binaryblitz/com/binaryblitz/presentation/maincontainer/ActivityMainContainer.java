package binaryblitz.com.binaryblitz.presentation.maincontainer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.presentation.maincontainer.interfaces.IMainContainerView;
import binaryblitz.com.binaryblitz.presentation.userlist.FragmentUserListView;


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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onAddUserClick();
            }
        });
        getSupportLoaderManager().initLoader(0, null, this);
    }

    private void setListFragment() {
        FragmentUserListView fragment = new FragmentUserListView();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.user_list_container, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void setUserList() {
        setListFragment();
    }

    @Override
    public void showAddUser() {
        if(mTwoPane){
            // show in dialog fragment
        }else {

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
