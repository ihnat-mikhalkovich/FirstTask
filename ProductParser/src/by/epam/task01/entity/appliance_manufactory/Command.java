package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;

public interface Command {

    Appliance execute(String[] strings);

}
