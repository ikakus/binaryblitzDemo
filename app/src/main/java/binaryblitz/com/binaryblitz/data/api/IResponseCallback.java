package binaryblitz.com.binaryblitz.data.api;

/**
 * Created by ikakus on 10/26/17.
 */

public interface IResponseCallback<T> {
    void onResponse(T rModel);
    void onError(int errorCode, String errorMessage);
}