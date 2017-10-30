package binaryblitz.com.binaryblitz.presentation.createuser;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.NetworkingModule;
import dagger.Subcomponent;

/**
 * Created by ikakus on 10/27/17.
 */

@Singleton
@Subcomponent(modules = {ModuleCreateUser.class, NetworkingModule.class})
public interface ComponentCreateUser {
    void inject(LoaderCreateUser loaderCreateUser);
}