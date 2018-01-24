package by.epam.task01.main;

import by.epam.task01.dao.util.SourceFileLocation;
import by.epam.task01.dao.util.SourceFileReader;
import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.Oven;
import by.epam.task01.entity.Speakers;
import by.epam.task01.entity.criteria.Criteria;
import by.epam.task01.entity.criteria.SearchCriteria;
import by.epam.task01.service.ApplianceService;
import by.epam.task01.service.ServiceFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Appliance appliance;

        java.util.ArrayList<Appliance> appliances = new java.util.ArrayList<>();

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria<SearchCriteria.Speakers> criteriaAppliance = new Criteria<>();
        criteriaAppliance.setApplianceType("Speakers");
        criteriaAppliance.add(SearchCriteria.Speakers.POWER_CONSUMPTION, "15");

        try {
            appliance = service.find(criteriaAppliance);
            PrintApplianceInfo.print(appliance);

            Speakers speakers;

            if (appliance instanceof Speakers) {
                speakers = (Speakers) appliance;
                PrintApplianceInfo.print(speakers);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
