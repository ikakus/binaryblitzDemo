package binaryblitz.com.binaryblitz.presentation.edituser;

import binaryblitz.com.binaryblitz.UserInteractionBus;
import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;
import binaryblitz.com.binaryblitz.data.presentation.EditUserModel;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserInteractor;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserView;
import binaryblitz.com.binaryblitz.utils.UserFieldsValidator;

/**
 * Created by ikakus on 10/27/17.
 */

public class PresenterEditUser implements Presenter<IEditUserView>, IEditUserInteractor.UserEditListener {
    private final UserInteractionBus mBus;
    private IEditUserInteractor mInteractorEditUser;
    private IEditUserView mView;
    private String mFistName;
    private String mLastName;
    private String mEmail;

    private boolean mIsRetained = false;
    private UserModel mUserModel;

    public PresenterEditUser(IEditUserInteractor interactorEditUser, UserInteractionBus userInteractionBus) {
        mInteractorEditUser = interactorEditUser;
        mBus = userInteractionBus;
    }

    @Override
    public void onViewAttached(IEditUserView view) {
        mView = view;
        if (mIsRetained) {
            mView.setFirstName(mFistName);
            mView.setLastName(mLastName);
            mView.setEmail(mEmail);
        }
        mIsRetained = true;
    }

    @Override
    public void onViewDetached() {
        mFistName = mView.getFirstName();
        mLastName = mView.getLastName();
        mEmail = mView.getEmail();
    }

    @Override
    public void onDestroyed() {

    }

    public void onEditUserClick() {
        boolean allFieldsValid = true;
        if (!validateFirstName()) {
            mView.showErrorFirstName("Mandatory field");
            allFieldsValid = false;
        }

        if (!validateLastName()) {
            mView.showErrorLastName("Mandatory field");
            allFieldsValid = false;
        }

        if (!validateEmail()) {
            mView.showErrorEmail("Wrong email format");
            allFieldsValid = false;
        }

        if (allFieldsValid) {
            EditUserModel editUserModel = new EditUserModel(
                    mUserModel.getId(),
                    mView.getFirstName(),
                    mView.getLastName(),
                    mView.getEmail(),
                    mView.getAvatarUrl()
            );
            mInteractorEditUser.editUser(editUserModel, this);
        }
    }

    private boolean validateFirstName() {
        String firstName = mView.getFirstName();
        return UserFieldsValidator.validateTextField(firstName);
    }

    private boolean validateLastName() {
        String lastName = mView.getLastName();
        return UserFieldsValidator.validateTextField(lastName);
    }

    private boolean validateEmail() {
        String email = mView.getEmail();
        return UserFieldsValidator.validateEmail(email);
    }

    @Override
    public void onError(String error) {
        mView.showError(error);
    }

    @Override
    public void onSuccess(UserModelR userModels) {
        mBus.onUserEditDone();
        mView.close();
    }

    public void setUserModel(UserModel userModel) {
        mUserModel = userModel;
        if (userModel != null) {
            mView.setFirstName(userModel.getFirstName());
            mView.setLastName(userModel.getLastName());
            mView.setEmail(userModel.getEmail());
            mView.setAvatar(userModel.getAvatarUrl());
        }
    }
}
