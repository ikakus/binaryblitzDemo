package binaryblitz.com.binaryblitz.presentation.maincontainer;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.AppModule;
import dagger.Component;

/**
 * Created by ikakus on 10/27/17.
 */


@Singleton
@Component(modules = {ModuleMainContainer.class, AppModule.class})
interface ComponentMainContainer {
    void inject(LoaderMainContainer loaderMainContainer);
}
