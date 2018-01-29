package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.VacuumCleaner;

public class VacuumCleanerCreator implements Command {

    @Override
    public Appliance execute(String[] strings) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.put(strings);
        return vacuumCleaner;
    }

}
