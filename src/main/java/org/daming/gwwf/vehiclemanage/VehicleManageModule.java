package org.daming.gwwf.vehiclemanage;

import com.google.inject.AbstractModule;
import org.daming.gwwf.vehiclemanage.dao.IVehicleManageDAO;
import org.daming.gwwf.vehiclemanage.dao.impl.VehicleManageDAO;
import org.daming.gwwf.vehiclemanage.service.IVehicleManageService;
import org.daming.gwwf.vehiclemanage.service.impl.VehicleManageService;

public class VehicleManageModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IVehicleManageDAO.class).toInstance(new VehicleManageDAO());
        bind(IVehicleManageService.class).to(VehicleManageService.class);
    }
}
