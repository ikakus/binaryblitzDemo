package binaryblitz.com.binaryblitz.presentation.userlist;

/**
 * Created by ikakus on 10/25/17.
 */

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.NetworkingModule;
import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {ModuleUserList.class, NetworkingModule.class})
public interface ComponentUserList {
    void inject(LoaderUserList tPresenterLoader);
}
