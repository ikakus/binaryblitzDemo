package binaryblitz.com.binaryblitz.di;

import javax.inject.Singleton;

import binaryblitz.com.binaryblitz.di.modules.AppModule;
import binaryblitz.com.binaryblitz.presentation.createuser.ComponentCreateUser;
import binaryblitz.com.binaryblitz.presentation.createuser.ModuleCreateUser;
import binaryblitz.com.binaryblitz.presentation.edituser.ComponentEditUser;
import binaryblitz.com.binaryblitz.presentation.edituser.ModuleEditUser;
import binaryblitz.com.binaryblitz.presentation.maincontainer.ComponentMainContainer;
import binaryblitz.com.binaryblitz.presentation.maincontainer.ModuleMainContainer;
import binaryblitz.com.binaryblitz.presentation.userlist.ComponentUserList;
import binaryblitz.com.binaryblitz.presentation.userlist.ModuleUserList;
import dagger.Component;

/**
 * Created by ikakus on 10/26/17.
 */

@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent{

    ComponentCreateUser plusCreateUserComponent(ModuleCreateUser moduleCreateUser);

    ComponentEditUser plusEditUserComponent(ModuleEditUser moduleEditUser);

    ComponentUserList plusUserListComponent(ModuleUserList moduleUserList);

    ComponentMainContainer plusMainContainerComponent(ModuleMainContainer moduleMainContainer);
}