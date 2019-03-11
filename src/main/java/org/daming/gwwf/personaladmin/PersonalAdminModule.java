package org.daming.gwwf.personaladmin;

import com.google.inject.AbstractModule;
import org.daming.gwwf.personaladmin.dao.IPersonAdminDAO;
import org.daming.gwwf.personaladmin.dao.impl.PersonAdminDAO;
import org.daming.gwwf.personaladmin.service.IPersonAdminService;
import org.daming.gwwf.personaladmin.service.impl.PersonAdminService;

public class PersonalAdminModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IPersonAdminDAO.class).toInstance(new PersonAdminDAO());
        bind(IPersonAdminService.class).to(PersonAdminService.class);
    }
}
