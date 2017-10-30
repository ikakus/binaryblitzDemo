package binaryblitz.com.binaryblitz.presentation.edituser;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import timber.log.Timber;

/**
 * Created by ikakus on 10/27/17.
 */

public class DialogFragmentEditUser extends DialogFragment implements IEditUserView, LoaderManager.LoaderCallbacks<PresenterEditUser> {
    @BindView(R.id.imageView_avatar)
    ImageView mImageViewAvatar;
    @BindView(R.id.textInputLayout_firstName)
    TextInputLayout mTextInputLayoutFirstName;
    @BindView(R.id.textInputLayout_lastName)
    TextInputLayout mTextInputLayoutLastName;
    @BindView(R.id.textInputLayout_email)
    TextInputLayout mTextInputLayoutEmail;
    private PresenterEditUser mPresenter;
    private Unbinder unbinder;
    private UserModel mUserModel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edit_user, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mUserModel = bundle.getParcelable(UserModel.USER_MODEL);
//            if(mUserModel != null){
//                setFirstName(mUserModel.getFirstName());
//                setLastName(mUserModel.getLastName());
//                setEmail(mUserModel.getEmail());
//                setAvatar(mUserModel.getAvatarUrl());
//            }
        }
        return rootView;
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
                Picasso.with(getContext())
                        .load(avatarUrl)
                        .error(R.mipmap.ic_launcher_round)
                        .into(mImageViewAvatar);
            } else {
                Picasso.with(getContext())
                        .load(R.mipmap.ic_launcher_round)
                        .into(mImageViewAvatar);
            }
        } catch (Exception e) {
            Timber.e(e);
            Picasso.with(getContext())
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
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void close() {
        Toast.makeText(getContext(), "User updated successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<PresenterEditUser> onCreateLoader(int id, Bundle args) {
        return new LoaderEditUser(getContext());
    }

    @Override
    public void onLoadFinished(Loader<PresenterEditUser> loader, PresenterEditUser presenter) {
        mPresenter = presenter;
        mPresenter.onViewAttached(this);
        mPresenter.setUserModel(mUserModel);
    }

    @Override
    public void onLoaderReset(Loader<PresenterEditUser> loader) {
        mPresenter = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onViewDetached();
        unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
}
