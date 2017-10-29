package binaryblitz.com.binaryblitz.presentation.edituser;

import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.data.api.ErrorHandlingSubscriber;
import binaryblitz.com.binaryblitz.data.api.IResponseCallback;
import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.networking.request.EditUserRequestW;
import binaryblitz.com.binaryblitz.data.networking.request.UserModelP;
import binaryblitz.com.binaryblitz.data.presentation.EditUserModel;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserInteractor;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ikakus on 10/27/17.
 */

public class InteractorEditUser implements IEditUserInteractor, IResponseCallback<BaseResponse> {

    private final ApiEndpointInterface mApi;
    private UserEditListener mListener;
    private Subscription mSubscription;

    public InteractorEditUser(ApiEndpointInterface apiEndpointInterface) {
        mApi = apiEndpointInterface;
    }

    @Override
    public void editUser(EditUserModel editUserModel, UserEditListener listener) {
        mListener = listener;
        EditUserRequestW createUserRequestW = new EditUserRequestW();
        createUserRequestW.setUser(new UserModelP(editUserModel));
        Observable<Response<BaseResponse>> call = mApi.patchUser(editUserModel.getId() ,createUserRequestW);
        mSubscription = call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new EditUserSubscriber(this));
    }

    @Override
    public void onResponse(BaseResponse rModel) {
        mListener.onSuccess(rModel);
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        mListener.onError(errorMessage);
    }

    private class EditUserSubscriber extends ErrorHandlingSubscriber<BaseResponse> {
        public EditUserSubscriber(IResponseCallback<BaseResponse> iResponseCallback) {
            super(iResponseCallback);
        }
    }
}
