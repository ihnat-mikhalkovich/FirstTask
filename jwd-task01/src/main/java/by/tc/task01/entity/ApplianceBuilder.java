package by.tc.task01.entity;

public class ApplianceBuilder {

    public static Appliance build(String applianceType){
        Appliance appliance = null;

        String[] types = {"Oven", "Laptop", "Refrigerator", "VacuumCleaner", "TabletPC", "Speakers"};

        if (applianceType.equals(types[0])) {
            appliance = new Oven();
        }
        else if(applianceType.equals(types[1])){
            appliance = new Laptop();
        }
        else if(applianceType.equals(types[2])){
            appliance = new Refrigerator();
        }
        else if(applianceType.equals(types[3])){
            appliance = new VacuumCleaner();
        }
        else if(applianceType.equals(types[4])){
            appliance = new TabletPC();
        }
        else if(applianceType.equals(types[5])){
            appliance = new Speakers();
        }

        return appliance;
    }

    public static String[] creatingFields(String line){
        String[] fieldsOfAppliance = line.split(" ");
        return fieldsOfAppliance;
    }

}
