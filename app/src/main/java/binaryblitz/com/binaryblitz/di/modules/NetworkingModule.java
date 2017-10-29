package binaryblitz.com.binaryblitz.di.modules;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import binaryblitz.com.binaryblitz.BuildConfig;
import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.data.api.JsonBodyInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by ikakus on 10/26/17.
 */
@Module
public class NetworkingModule {
    private final String BASE_URL = BuildConfig.API_BASE_URL;

    @Provides
    Cache provideHttpCache(Context context) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    HttpLoggingInterceptor.Logger provideLogger() {

        Logger.init()                 // default PRETTYLOGGER or use just init()
                .methodCount(2)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
        ;
        return new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Logger.d(message);
            }
        };
    }

    @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    OkHttpClient provideOkhttpClient(Cache cache) {
        JsonBodyInterceptor loggingInterceptor = new JsonBodyInterceptor();
        loggingInterceptor.setLevel(JsonBodyInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);

        if(BuildConfig.DEBUG) {
            client.addInterceptor(loggingInterceptor);
        }

        return client.build();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    ApiEndpointInterface provideApiEndpointInterface(Retrofit retrofit) {
        return retrofit.create(ApiEndpointInterface.class);
    }
}
