package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.Laptop;

public class LaptopCreator implements Command {

    @Override
    public Appliance execute(String[] strings) {
        Laptop laptop = new Laptop();
        laptop.put(strings);
        return laptop;
    }

}
