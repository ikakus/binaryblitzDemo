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

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
