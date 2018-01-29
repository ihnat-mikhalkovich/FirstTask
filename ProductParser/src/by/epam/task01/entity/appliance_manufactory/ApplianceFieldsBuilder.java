package by.epam.task01.entity.appliance_manufactory;

public class ApplianceFieldsBuilder {

    public static String[] creatingFields(String line){
        String[] fieldsOfAppliance = line.split(" ");
        return fieldsOfAppliance;
    }

}
