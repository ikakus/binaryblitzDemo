package binaryblitz.com.binaryblitz.presentation.adduser;

import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.data.api.ErrorHandlingSubscriber;
import binaryblitz.com.binaryblitz.data.api.IResponseCallback;
import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.networking.request.CreateUserRequestW;
import binaryblitz.com.binaryblitz.data.networking.request.UserModelP;
import binaryblitz.com.binaryblitz.data.presentation.CreateUserModel;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.ICreateUserInteractor;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ikakus on 10/27/17.
 */

public class InteractorCreateUser implements ICreateUserInteractor, IResponseCallback<BaseResponse> {

    private final ApiEndpointInterface mApi;
    private UserAddedListener mListener;
    private Subscription mSubscription;

    public InteractorCreateUser(ApiEndpointInterface apiEndpointInterface) {
        mApi = apiEndpointInterface;
    }

    @Override
    public void addUser( CreateUserModel createUserModel, UserAddedListener listener) {
        mListener = listener;
        CreateUserRequestW createUserRequestW = new CreateUserRequestW();
        createUserRequestW.setUser(new UserModelP(createUserModel));
        Observable<Response<BaseResponse>> call = mApi.createUser(createUserRequestW);
        mSubscription = call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CreateUserSubscriber(this));
    }

    @Override
    public void onResponse(BaseResponse rModel) {

    }

    @Override
    public void onError(int errorCode, String errorMessage) {

    }

    private class CreateUserSubscriber extends ErrorHandlingSubscriber<BaseResponse> {
        public CreateUserSubscriber(IResponseCallback<BaseResponse> iResponseCallback) {
            super(iResponseCallback);
        }
    }
}
