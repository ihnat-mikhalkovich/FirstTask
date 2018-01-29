package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.Oven;

public class OvenCreator implements Command {

    @Override
    public Appliance execute(String[] strings) {
        Oven oven = new Oven();
        oven.put(strings);
        return oven;
    }

}
