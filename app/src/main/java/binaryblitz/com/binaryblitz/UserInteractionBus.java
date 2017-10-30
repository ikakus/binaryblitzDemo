package binaryblitz.com.binaryblitz;

import java.util.ArrayList;
import java.util.List;

import binaryblitz.com.binaryblitz.data.presentation.UserModel;

/**
 * Created by ikakus on 10/29/17.
 */

public class UserInteractionBus {
    List<IUserEditIntentSubscriber> mIUserEditIntentSubscribers = new ArrayList<>();
    List<IUserEditDoneSubscriber> mIUserEditDoneSubscribers = new ArrayList<>();

    public void onUserEditClick(UserModel editUserModel){
        for (IUserEditIntentSubscriber iUserInteractionSubscriber : mIUserEditIntentSubscribers) {
            iUserInteractionSubscriber.onUserEdit(editUserModel);
        }
    }

    public void addEditUserIntentSubscriber(IUserEditIntentSubscriber subscriber){
        mIUserEditIntentSubscribers.add(subscriber);
    }

    public void onUserEditDone(){
        for (IUserEditDoneSubscriber iUserInteractionSubscriber : mIUserEditDoneSubscribers) {
            iUserInteractionSubscriber.onUserEditDone();
        }
    }

    public void addEditUserDoneSubscriber(IUserEditDoneSubscriber subscriber){
        mIUserEditDoneSubscribers.add(subscriber);
    }

    public interface IUserEditIntentSubscriber {
        void onUserEdit(UserModel userModel);
    }

    public interface IUserEditDoneSubscriber {
        void onUserEditDone();
    }
}
