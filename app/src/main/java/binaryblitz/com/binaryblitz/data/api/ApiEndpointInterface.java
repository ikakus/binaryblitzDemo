package binaryblitz.com.binaryblitz.data.api;

import java.util.List;

import binaryblitz.com.binaryblitz.data.networking.BaseResponse;
import binaryblitz.com.binaryblitz.data.networking.request.CreateUserRequestW;
import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ikakus on 10/26/17.
 */

public interface ApiEndpointInterface {
    @GET("users.json")
    Observable<Response<List<UserModelR>>> getUsers();

    @POST("users.json")
    Observable<Response<BaseResponse>> createUser(@Body CreateUserRequestW createUserRequestW);
}
