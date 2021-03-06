package binaryblitz.com.binaryblitz.presentation.createuser;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.presentation.createuser.interfaces.ICreateUserView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ikakus on 10/27/17.
 */

public class DialogFragmentCreateUser extends DialogFragment implements ICreateUserView, LoaderManager.LoaderCallbacks<PresenterCreateUser> {
    @BindView(R.id.imageView_avatar)
    ImageView mImageViewAvatar;
    @BindView(R.id.textInputLayout_firstName)
    TextInputLayout mTextInputLayoutFirstName;
    @BindView(R.id.textInputLayout_lastName)
    TextInputLayout mTextInputLayoutLastName;
    @BindView(R.id.textInputLayout_email)
    TextInputLayout mTextInputLayoutEmail;
    private PresenterCreateUser mPresenter;
    private Unbinder unbinder;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_user, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        WindowManager.LayoutParams wmlp = getDialog().getWindow().getAttributes();
        wmlp.gravity = Gravity.FILL_HORIZONTAL;
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
        Toast.makeText(getContext(), "User created", Toast.LENGTH_SHORT).show();
        dismiss();
    }

    @Override
    public Loader<PresenterCreateUser> onCreateLoader(int id, Bundle args) {
        return new LoaderCreateUser(getContext());
    }

    @Override
    public void onLoadFinished(Loader<PresenterCreateUser> loader, PresenterCreateUser presenter) {
        mPresenter = presenter;
        mPresenter.onViewAttached(this);
    }

    @Override
    public void onLoaderReset(Loader<PresenterCreateUser> loader) {
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

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        super.onResume();
    }

    @OnClick({R.id.imageView_avatar, R.id.buttonCreate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView_avatar:
                break;
            case R.id.buttonCreate:
                mTextInputLayoutFirstName.setError(null);
                mTextInputLayoutLastName.setError(null);
                mTextInputLayoutEmail.setError(null);
                mPresenter.onCreateUserClick();
                break;
        }
    }
}
