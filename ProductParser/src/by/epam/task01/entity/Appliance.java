package by.epam.task01.entity;

import java.util.ArrayList;

public class Appliance {

    private ArrayList<String> appliance = new ArrayList<>();
    private String applianceType;

    public Appliance(){}

    public String getApplianceType() {
        return applianceType;
    }

    public ArrayList<String> getAppliance() {
        return appliance;
    }

    public void put(String[] fieldsOfAppliance){
        applianceType = fieldsOfAppliance[0];
        int firstCriteria = 1;
        for (int i = firstCriteria; i < fieldsOfAppliance.length; i++){
            if (!fieldsOfAppliance[i].equals("")) appliance.add(fieldsOfAppliance[i]);
        }
    }

    public String toStringInfo(){
        String thisInfo = applianceType + " : ";
        int counter = 0;
        for (String criteria : appliance) {
            thisInfo = thisInfo + criteria;
            if (counter < appliance.size()-1) {
                thisInfo = thisInfo + ", ";
            }
            counter++;
        }
        thisInfo = thisInfo + ";";
        return thisInfo;
    }

}
