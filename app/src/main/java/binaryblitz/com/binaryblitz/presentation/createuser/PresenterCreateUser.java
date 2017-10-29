package binaryblitz.com.binaryblitz.presentation.createuser;

import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;
import binaryblitz.com.binaryblitz.data.presentation.CreateUserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.createuser.interfaces.ICreateUserInteractor;
import binaryblitz.com.binaryblitz.presentation.createuser.interfaces.ICreateUserView;
import binaryblitz.com.binaryblitz.utils.UserFieldsValidator;

/**
 * Created by ikakus on 10/27/17.
 */

public class PresenterCreateUser implements Presenter<ICreateUserView>, ICreateUserInteractor.UserAddedListener {
    private ICreateUserInteractor mInteractorCreateUser;
    private ICreateUserView mView;
    private String mFistName;
    private String mLastName;
    private String mEmail;

    private boolean mIsRetained = false;

    public PresenterCreateUser(ICreateUserInteractor interactorCreateUser) {
        mInteractorCreateUser = interactorCreateUser;
    }

    @Override
    public void onViewAttached(ICreateUserView view) {
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

    public void onCreateUserClick() {
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
            CreateUserModel createUserModel = new CreateUserModel(
                    mView.getFirstName(),
                    mView.getLastName(),
                    mView.getEmail(),
                    mView.getAvatarUrl()
            );
            mInteractorCreateUser.addUser(createUserModel, this);
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
        mView.close();
    }
}
