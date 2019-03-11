package org.daming.gwwf.office;


import com.google.inject.AbstractModule;
import org.daming.gwwf.office.dao.IOfficeDAO;
import org.daming.gwwf.office.dao.impl.OfficeDAO;
import org.daming.gwwf.office.service.IOfficeService;
import org.daming.gwwf.office.service.impl.OfficeService;

public class OfficeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IOfficeDAO.class).toInstance(new OfficeDAO());
        bind(IOfficeService.class).to(OfficeService.class);
    }
}
