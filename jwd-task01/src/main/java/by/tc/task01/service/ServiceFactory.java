package by.tc.task01.service;

import by.tc.task01.service.Impl.ApplianceServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ApplianceService applianceService = new ApplianceServiceImpl();

    public ApplianceService getApplianceService(){
        return applianceService;
    }

    public static ServiceFactory getInstance(){
        return instance;
    }
}
