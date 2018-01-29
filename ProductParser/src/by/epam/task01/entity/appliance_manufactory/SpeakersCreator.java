package by.epam.task01.entity.appliance_manufactory;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.Speakers;

public class SpeakersCreator implements Command {

    @Override
    public Appliance execute(String[] strings) {
        Speakers speakers = new Speakers();
        speakers.put(strings);
        return speakers;
    }

}
