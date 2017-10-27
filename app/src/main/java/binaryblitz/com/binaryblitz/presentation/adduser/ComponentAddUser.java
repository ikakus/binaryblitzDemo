package binaryblitz.com.binaryblitz.presentation.adduser;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.AppModule;
import binaryblitz.com.binaryblitz.di.modules.NetworkingModule;
import dagger.Component;

/**
 * Created by ikakus on 10/27/17.
 */

@Singleton
@Component(modules = {ModuleAddUser.class, NetworkingModule.class, AppModule.class})
public interface ComponentAddUser {
    void inject(LoaderAddUser loaderAddUser);
}