package binaryblitz.com.binaryblitz.presentation.edituser;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.NetworkingModule;
import dagger.Subcomponent;

/**
 * Created by ikakus on 10/27/17.
 */

@Singleton
@Subcomponent(modules = {ModuleEditUser.class, NetworkingModule.class})
public interface ComponentEditUser {
    void inject(LoaderEditUser loaderEditUser);
}