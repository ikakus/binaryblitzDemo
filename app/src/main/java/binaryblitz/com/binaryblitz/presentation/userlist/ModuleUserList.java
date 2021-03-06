package binaryblitz.com.binaryblitz.presentation.userlist;


import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.UserInteractionBus;
import binaryblitz.com.binaryblitz.data.api.ApiEndpointInterface;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IUserListInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 10/25/17.
 */
@Module
public class ModuleUserList {
    @Singleton
    @Provides
    public PresenterUserList providePresenter(IUserListInteractor iUserListInteractor, UserInteractionBus userInteractionBus) {
        return new PresenterUserList(iUserListInteractor, userInteractionBus);
    }

    @Singleton
    @Provides
    public IUserListInteractor provideInteractor(ApiEndpointInterface apiEndpointInterface) {
        return new InteractorUserList(apiEndpointInterface);
    }
}
