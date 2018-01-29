package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.Refrigerator;

public class RefrigeratorCreator implements Command {

    @Override
    public Appliance execute(String[] strings) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.put(strings);
        return refrigerator;
    }

}
