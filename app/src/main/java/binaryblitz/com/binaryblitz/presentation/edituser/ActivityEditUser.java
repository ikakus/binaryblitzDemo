package binaryblitz.com.binaryblitz.presentation.edituser;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserView;
import binaryblitz.com.binaryblitz.presentation.maincontainer.ActivityMainContainer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by ikakus on 10/28/17.
 */

public class ActivityEditUser extends AppCompatActivity implements IEditUserView, LoaderManager.LoaderCallbacks<PresenterEditUser> {

    @BindView(R.id.imageView_avatar)
    ImageView mImageViewAvatar;
    @BindView(R.id.textInputLayout_firstName)
    TextInputLayout mTextInputLayoutFirstName;
    @BindView(R.id.textInputLayout_lastName)
    TextInputLayout mTextInputLayoutLastName;
    @BindView(R.id.textInputLayout_email)
    TextInputLayout mTextInputLayoutEmail;

    private PresenterEditUser mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ButterKnife.bind(this);
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public String getFirstName() {
        return mTextInputLayoutFirstName.getEditText().getText().toString();
    }

    @Override
    public void setFirstName(String fistName) {
        mTextInputLayoutFirstName.getEditText().setText(fistName);
    }

    @Override
    public String getLastName() {
        return mTextInputLayoutLastName.getEditText().getText().toString();
    }

    @Override
    public void setLastName(String lastName) {
        mTextInputLayoutLastName.getEditText().setText(lastName);
    }

    @Override
    public String getEmail() {
        return mTextInputLayoutEmail.getEditText().getText().toString();
    }

    @Override
    public void setEmail(String email) {
        mTextInputLayoutEmail.getEditText().setText(email);
    }

    @Override
    public String getAvatarUrl() {
        return "";
    }

    @Override
    public void setAvatar(String avatarUrl) {
        try {

            if (avatarUrl != null) {
                Picasso.with(this)
                        .load(avatarUrl)
                        .error(R.mipmap.ic_launcher_round)
                        .into(mImageViewAvatar);
            } else {
                Picasso.with(this)
                        .load(R.mipmap.ic_launcher_round)
                        .into(mImageViewAvatar);
            }
        } catch (Exception e) {
            Timber.e(e);
            Picasso.with(this)
                    .load(R.mipmap.ic_launcher_round)
                    .into(mImageViewAvatar);
        }
    }

    @Override
    public void showErrorFirstName(String errorMessage) {
        mTextInputLayoutFirstName.setError(errorMessage);
    }

    @Override
    public void showErrorLastName(String errorMessage) {
        mTextInputLayoutLastName.setError(errorMessage);
    }

    @Override
    public void showErrorEmail(String errorMessage) {
        mTextInputLayoutEmail.setError(errorMessage);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void close() {
        Toast.makeText(this, "User updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.imageView_avatar, R.id.buttonEdit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_avatar:
                break;
            case R.id.buttonEdit:
                mTextInputLayoutFirstName.setError(null);
                mTextInputLayoutLastName.setError(null);
                mTextInputLayoutEmail.setError(null);
                mPresenter.onEditUserClick();
                break;
        }
    }

    @Override
    public Loader<PresenterEditUser> onCreateLoader(int i, Bundle bundle) {
        return new LoaderEditUser(this);
    }

    @Override
    public void onLoadFinished(Loader<PresenterEditUser> loader, PresenterEditUser presenter) {
        mPresenter = presenter;
        mPresenter.onViewAttached(this);
        UserModel userModel = (UserModel) getIntent().getParcelableExtra(UserModel.USER_MODEL);
        mPresenter.setUserModel(userModel);
    }

    @Override
    public void onLoaderReset(Loader<PresenterEditUser> loader) {
        mPresenter = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ActivityMainContainer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}