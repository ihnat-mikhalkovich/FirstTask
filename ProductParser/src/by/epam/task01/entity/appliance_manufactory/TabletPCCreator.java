package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.TabletPC;

public class TabletPCCreator implements Command {

    @Override
    public Appliance execute(String[] strings) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.put(strings);
        return tabletPC;
    }

}
