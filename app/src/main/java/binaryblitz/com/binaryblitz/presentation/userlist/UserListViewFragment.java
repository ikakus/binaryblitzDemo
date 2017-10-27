package binaryblitz.com.binaryblitz.presentation.userlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IViewUserList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ikakus on 10/27/17.
 */

public class UserListViewFragment extends Fragment implements IViewUserList, LoaderManager.LoaderCallbacks<PresenterUserList> {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private PresenterUserList mPresenter;
    private TextView mText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void show(String s) {
        mText.setText(s);
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<PresenterUserList> onCreateLoader(int i, Bundle bundle) {
        return new LoaderUserList(getContext());
    }

    @Override
    public void onLoadFinished(Loader<PresenterUserList> loader, PresenterUserList presenter) {
        mPresenter = presenter;
        mPresenter.onViewAttached(this);
    }

    @Override
    public void onLoaderReset(Loader<PresenterUserList> loader) {
        mPresenter = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
