package binaryblitz.com.binaryblitz.presentation.adduser;

import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.data.api.ErrorHandlingSubscriber;
import binaryblitz.com.binaryblitz.data.api.IResponseCallback;
import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.networking.request.UserModelP;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.IAddUserInteractor;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ikakus on 10/27/17.
 */

public class InteractorAddUser implements IAddUserInteractor, IResponseCallback<BaseResponse> {

    private final ApiEndpointInterface mApi;
    private UserAddedListener mListener;
    private Subscription mSubscription;

    public InteractorAddUser(ApiEndpointInterface apiEndpointInterface) {
        mApi = apiEndpointInterface;
    }

    @Override
    public void addUser(UserAddedListener listener, UserModelP userModelP) {
        mListener = listener;
        Observable<Response<BaseResponse>> call = mApi.createUser(userModelP);
        mSubscription = call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AddUserSubscriber(this));
    }

    @Override
    public void onResponse(BaseResponse rModel) {

    }

    @Override
    public void onError(int errorCode, String errorMessage) {

    }

    private class AddUserSubscriber extends ErrorHandlingSubscriber<BaseResponse> {
        public AddUserSubscriber(IResponseCallback<BaseResponse> iResponseCallback) {
            super(iResponseCallback);
        }
    }
}
