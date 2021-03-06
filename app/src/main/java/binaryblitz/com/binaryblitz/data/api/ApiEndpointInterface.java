package binaryblitz.com.binaryblitz.data.api;

import java.util.List;

import binaryblitz.com.binaryblitz.data.networking.request.CreateUserRequestW;
import binaryblitz.com.binaryblitz.data.networking.request.EditUserRequestW;
import binaryblitz.com.binaryblitz.data.networking.response.UserModelR;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ikakus on 10/26/17.
 */

public interface ApiEndpointInterface {
    @GET("users.json")
    Observable<Response<List<UserModelR>>> getUsers();

    @POST("users.json")
    Observable<Response<UserModelR>> createUser(@Body CreateUserRequestW createUserRequestW);

    @PATCH("users/{id}.json")
    Observable<Response<UserModelR>> patchUser(@Path("id") int id, @Body EditUserRequestW createUserRequestW);
}
