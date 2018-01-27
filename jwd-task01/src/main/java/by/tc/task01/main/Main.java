package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Appliance appliance;

        ArrayList<Appliance> appliances = new ArrayList<Appliance>();

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria<SearchCriteria.Oven> criteriaAppliance = new Criteria<SearchCriteria.Oven>();
        criteriaAppliance.setApplianceType("Oven");
        criteriaAppliance.add(SearchCriteria.Oven.POWER_CONSUMPTION, "2000");

        try {
            appliance = service.find(criteriaAppliance);
            Oven oven;
            if (appliance instanceof Oven) {
                oven = (Oven) appliance;
                PrintApplianceInfo.print(oven);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
