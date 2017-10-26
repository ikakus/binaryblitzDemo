package binaryblitz.com.binaryblitz.data.api;

import retrofit2.Response;
import rx.Subscriber;
import timber.log.Timber;

/**
 * Created by ikakus on 10/26/17.
 */

public class ErrorHandlingSubscriber<T> extends Subscriber<Response<T>> {
    IResponseCallback<T> mResponseCallback;

    public ErrorHandlingSubscriber(IResponseCallback<T> iResponseCallback) {
        mResponseCallback = iResponseCallback;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (mResponseCallback != null) {
            mResponseCallback.onError(500, e.getMessage());
        }
        Timber.e(e);
    }

    @Override
    public void onNext(Response<T> tResponseModel) {
        if (tResponseModel.isSuccessful()) {
            if (mResponseCallback != null) {
                mResponseCallback.onResponse(tResponseModel.body());
            }
        } else {
            if (mResponseCallback != null) {
                mResponseCallback.onError(tResponseModel.code(), tResponseModel.message());
            }
        }
    }
}