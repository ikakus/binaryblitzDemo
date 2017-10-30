package binaryblitz.com.binaryblitz.presentation.maincontainer;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by ikakus on 10/27/17.
 */


@Singleton
@Subcomponent(modules = {ModuleMainContainer.class})
public interface ComponentMainContainer {
    void inject(LoaderMainContainer loaderMainContainer);
}
