package binaryblitz.com.binaryblitz.presentation.userlist;

/**
 * Created by ikakus on 10/25/17.
 */

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.AppModule;
import binaryblitz.com.binaryblitz.di.modules.NetworkingModule;
import dagger.Component;

@Singleton
@Component(modules = {ModuleUserList.class, NetworkingModule.class, AppModule.class})
interface ComponentUserList {
    void inject(LoaderUserList tPresenterLoader);
}
