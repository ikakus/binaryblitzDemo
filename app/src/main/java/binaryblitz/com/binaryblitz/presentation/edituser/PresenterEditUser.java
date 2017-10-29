package binaryblitz.com.binaryblitz.presentation.edituser;

import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.presentation.EditUserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserInteractor;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserView;
import binaryblitz.com.binaryblitz.utils.UserFieldsValidator;

/**
 * Created by ikakus on 10/27/17.
 */

public class PresenterEditUser implements Presenter<IEditUserView>, IEditUserInteractor.UserEditListener {
    private IEditUserInteractor mInteractorEditUser;
    private IEditUserView mView;
    private String mFistName;
    private String mLastName;
    private String mEmail;

    private boolean mIsRetained = false;

    public PresenterEditUser(IEditUserInteractor interactorEditUser) {
        mInteractorEditUser = interactorEditUser;
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
            EditUserModel createUserModel = new EditUserModel(
                    1,
                    mView.getFirstName(),
                    mView.getLastName(),
                    mView.getEmail(),
                    mView.getAvatarUrl()
            );
            mInteractorEditUser.editUser(createUserModel, this);
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
    public void onSuccess(BaseResponse userModels) {
        mView.close();
    }
}
