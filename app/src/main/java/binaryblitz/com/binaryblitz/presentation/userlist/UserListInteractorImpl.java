package binaryblitz.com.binaryblitz.presentation.userlist;

import java.util.ArrayList;
import java.util.List;

import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.data.api.ErrorHandlingSubscriber;
import binaryblitz.com.binaryblitz.data.api.IResponseCallback;
import binaryblitz.com.binaryblitz.data.networking.UserModelR;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IUserListInteractor;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ikakus on 10/26/17.
 */

public class UserListInteractorImpl implements IUserListInteractor, IResponseCallback<List<UserModelR>> {
    private final ApiEndpointInterface mApi;
    private UsersLoadedListener mListener;
    private Subscription mSubscription;

    public UserListInteractorImpl(ApiEndpointInterface apiEndpointInterface) {
        mApi = apiEndpointInterface;
    }

    @Override
    public void getUsers(UsersLoadedListener listener) {
        mListener = listener;
        Observable<Response<List<UserModelR>>> call = mApi.getUsers();
        mSubscription = call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new UserListSubscriber(this));
    }

    @Override
    public void onResponse(List<UserModelR> userModelRS) {
        if (mListener != null) {
            // TODO convert
            List<UserModel> userModels = new ArrayList<>();
            mListener.onSuccess(userModels);
        }
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        if(mListener != null) {
            mListener.onError(errorMessage);
        }
    }

    private class UserListSubscriber extends ErrorHandlingSubscriber<List<UserModelR>> {
        public UserListSubscriber(IResponseCallback<List<UserModelR>> iResponseCallback) {
            super(iResponseCallback);
        }
    }
}
