package binaryblitz.com.binaryblitz;

import android.app.Application;

import binaryblitz.com.binaryblitz.di.AppComponent;
import binaryblitz.com.binaryblitz.di.DaggerAppComponent;
import binaryblitz.com.binaryblitz.di.modules.AppModule;
import timber.log.Timber;

/**
 * Created by ikakus on 10/26/17.
 */

public class App extends Application {

    private static AppComponent sAppComponent;
    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static AppComponent getAppComponent(){
        if(sAppComponent == null){
            sAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mContext))
                    .build();
        }
        return sAppComponent;
    }
}
