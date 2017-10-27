package binaryblitz.com.binaryblitz.presentation.adduser;

import binaryblitz.com.binaryblitz.presentation.Presenter;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.IAddUserInteractor;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.IAddUserView;

/**
 * Created by ikakus on 10/27/17.
 */

public class PresenterAddUser implements Presenter<IAddUserView> {
    private IAddUserInteractor mInteractorAddUser;
    private IAddUserView mView;

    public PresenterAddUser(IAddUserInteractor interactorAddUser) {
        mInteractorAddUser = interactorAddUser;
    }

    @Override
    public void onViewAttached(IAddUserView view) {
        mView = view;
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }

    public void onAddUserClick(){
        String firstName = mView.getFirstName();
        String lastName = mView.getLastName();
        String email = mView.getEmail();

        UserFiledsValidator.validateEmail(email);
    }
}
