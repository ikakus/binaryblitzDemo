package binaryblitz.com.binaryblitz.data.api;

import java.util.List;

import binaryblitz.com.binaryblitz.data.networking.UserModelR;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ikakus on 10/26/17.
 */

public interface ApiEndpointInterface {
    @GET("users.json")
    Observable<Response<List<UserModelR>>> getUsers();
}
