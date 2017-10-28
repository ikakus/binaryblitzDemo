package binaryblitz.com.binaryblitz.presentation.createuser;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.presentation.createuser.interfaces.ICreateUserInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 10/27/17.
 */

@Module
public class ModuleCreateUser {
    @Singleton
    @Provides
    public PresenterCreateUser providePresenter(ICreateUserInteractor iCreateUserInteractor){
        return new PresenterCreateUser(iCreateUserInteractor);
    }

    @Singleton
    @Provides
    public ICreateUserInteractor provideInteractor(ApiEndpointInterface apiEndpointInterface){
        return new InteractorCreateUser(apiEndpointInterface);
    }
}
