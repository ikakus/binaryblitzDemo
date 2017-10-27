package binaryblitz.com.binaryblitz.presentation.adduser;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.presentation.adduser.interfaces.IAddUserInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 10/27/17.
 */

@Module
public class ModuleAddUser {
    @Singleton
    @Provides
    public PresenterAddUser providePresenter(IAddUserInteractor iAddUserInteractor){
        return new PresenterAddUser(iAddUserInteractor);
    }

    @Singleton
    @Provides
    public IAddUserInteractor provideInteractor(ApiEndpointInterface apiEndpointInterface){
        return new InteractorAddUser(apiEndpointInterface);
    }
}
