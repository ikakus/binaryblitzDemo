package binaryblitz.com.binaryblitz.di;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.AppModule;
import dagger.Component;

/**
 * Created by ikakus on 10/26/17.
 */

@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent{

}