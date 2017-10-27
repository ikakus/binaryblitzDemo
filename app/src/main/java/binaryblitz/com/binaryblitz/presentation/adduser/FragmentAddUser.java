package binaryblitz.com.binaryblitz.presentation.adduser;

import android.app.DialogFragment;

import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.IAddUserView;

/**
 * Created by ikakus on 10/27/17.
 */

public class FragmentAddUser extends DialogFragment implements IAddUserView{
    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getAvatarUrl() {
        return null;
    }

    @Override
    public void showErrorFirstName(String errorMessage) {

    }

    @Override
    public void showErrorLastName(String errorMessage) {

    }

    @Override
    public void showErrorEmail(String errorMessage) {

    }

    @Override
    public void close() {

    }
}
