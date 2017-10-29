package binaryblitz.com.binaryblitz;

import java.util.ArrayList;
import java.util.List;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;

/**
 * Created by ikakus on 10/29/17.
 */

public class UserInteractionBus {
    List<IUserInteractionSubscriber> mIUserInteractionSubscribers = new ArrayList<>();

    public void onUserEditClick(UserModel editUserModel){
        for (IUserInteractionSubscriber iUserInteractionSubscriber : mIUserInteractionSubscribers) {
            iUserInteractionSubscriber.onUserEdit(editUserModel);
        }
    }

    public void addSubscriber(IUserInteractionSubscriber subscriber){
        mIUserInteractionSubscribers.add(subscriber);
    }

    public interface IUserInteractionSubscriber{
        void onUserEdit(UserModel userModel);
    }
}
