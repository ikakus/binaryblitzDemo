package binaryblitz.com.binaryblitz.presentation.edituser;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.UserInteractionBus;
import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.presentation.edituser.interfaces.IEditUserInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 10/27/17.
 */

@Module
public class ModuleEditUser {
    @Singleton
    @Provides
    public PresenterEditUser providePresenter(IEditUserInteractor iEditUserInteractor, UserInteractionBus userInteractionBus) {
        return new PresenterEditUser(iEditUserInteractor, userInteractionBus);
    }

    @Singleton
    @Provides
    public IEditUserInteractor provideInteractor(ApiEndpointInterface apiEndpointInterface) {
        return new InteractorEditUser(apiEndpointInterface);
    }
}
