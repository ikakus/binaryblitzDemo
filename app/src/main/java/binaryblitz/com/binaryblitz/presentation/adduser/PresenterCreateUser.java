package binaryblitz.com.binaryblitz.presentation.adduser;

import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.presentation.CreateUserModel;
import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.ICreateUserInteractor;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.ICreateUserView;

/**
 * Created by ikakus on 10/27/17.
 */

public class PresenterCreateUser implements Presenter<ICreateUserView>,ICreateUserInteractor.UserAddedListener {
    private ICreateUserInteractor mInteractorCreateUser;
    private ICreateUserView mView;

    public PresenterCreateUser(ICreateUserInteractor interactorCreateUser) {
        mInteractorCreateUser = interactorCreateUser;
    }

    @Override
    public void onViewAttached(ICreateUserView view) {
        mView = view;
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }

    public void onCreateUserClick(){
        boolean allFieldsValid = true;
        if(validateFirstName()){
            mView.showErrorFirstName("Mandatory field");
        }else {
            allFieldsValid = false;
        }

        if(validateLastName()){
            mView.showErrorLastName("Mandatory field");
        }else {
            allFieldsValid = false;
        }

        if(validateEmail()){
            mView.showErrorEmail("Wrong email format");
        }else {
            allFieldsValid = false;
        }

        if(allFieldsValid){
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

    }

    @Override
    public void onSuccess(BaseResponse userModels) {
        mView.close();
    }
}
