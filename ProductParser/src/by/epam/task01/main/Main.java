package by.epam.task01.main;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.criteria.Criteria;
import by.epam.task01.entity.criteria.SearchCriteria;
import by.epam.task01.service.ApplianceService;
import by.epam.task01.service.ServiceFactory;

public class Main {

    public static void main(String[] args) {
        Appliance appliance;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria<SearchCriteria.Oven> criteriaAppliance = new Criteria<>();
        criteriaAppliance.setApplianceType("Oven");
        criteriaAppliance.add(SearchCriteria.Oven.CAPACITY, "32");

        try {
            appliance = service.find(criteriaAppliance);
            PrintApplianceInfo.print(appliance);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
