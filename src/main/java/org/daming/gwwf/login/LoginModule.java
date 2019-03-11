package org.daming.gwwf.login;

import com.google.inject.AbstractModule;
import org.daming.gwwf.login.dao.ILoginDAO;
import org.daming.gwwf.login.dao.impl.LoginDAO;
import org.daming.gwwf.login.service.ILoginService;
import org.daming.gwwf.login.service.impl.LoginService;

public class LoginModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ILoginDAO.class).toInstance(new LoginDAO());
        bind(ILoginService.class).to(LoginService.class);
    }

}
