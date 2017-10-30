package binaryblitz.com.binaryblitz.presentation.maincontainer;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.UserInteractionBus;
import binaryblitz.com.binaryblitz.presentation.maincontainer.interfaces.IMainContainerInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ikakus on 10/27/17.
 */


@Module
public class ModuleMainContainer {
    @Singleton
    @Provides
    public PresenterMainContainer providePresenter(UserInteractionBus userInteractionBus){
        return new PresenterMainContainer(userInteractionBus);
    }

    @Singleton
    @Provides
    public IMainContainerInteractor provideInteractor(){
        return new InteractorMainContainer();
    }
}
