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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appliance appliance1 = (Appliance) o;

        if (appliance != null ? !appliance.equals(appliance1.appliance) : appliance1.appliance != null) return false;
        return applianceType != null ? applianceType.equals(appliance1.applianceType) : appliance1.applianceType == null;
    }

    @Override
    public int hashCode() {
        int result = appliance != null ? appliance.hashCode() : 0;
        result = 31 * result + (applianceType != null ? applianceType.hashCode() : 0);
        return result;
    }
}
