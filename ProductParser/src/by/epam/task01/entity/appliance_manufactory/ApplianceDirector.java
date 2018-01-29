package by.epam.task01.entity.appliance_manufactory;

import java.util.HashMap;
import java.util.Map;

public class ApplianceDirector {

    private Map<String, Command> applianceMap = new HashMap<>();

    public ApplianceDirector() {
        applianceMap.put("Oven", new OvenCreator());
        applianceMap.put("Laptop", new LaptopCreator());
        applianceMap.put("Refrigerator", new RefrigeratorCreator());
        applianceMap.put("VacuumCleaner", new VacuumCleanerCreator());
        applianceMap.put("TabletPC", new TabletPCCreator());
        applianceMap.put("Speakers", new SpeakersCreator());
    }

    public Command getCommand(String typeName) {
        Command command;
        command = applianceMap.get(typeName);
        return command;
    }

}
