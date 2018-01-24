package by.epam.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

    private String applianceType;
    private Map<E, Object> criteria = new HashMap<>();

    public void add(E searchCriteria, Object value){
        criteria.put(searchCriteria, value);
    }

    public String getApplianceType(){
        return applianceType;
    }

    public void setApplianceType(String applianceType){
        this.applianceType = applianceType;
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }

    public String getCriteriaInfo(){
        String criteriaString = "Criteria<" + applianceType + ">[applianceType=" + applianceType +
                ";" + "Map<" + applianceType + ",Object>:(";
        int counter = 0;
        for (Map.Entry<E, Object> entry : criteria.entrySet()) {
            counter++;
            E key = entry.getKey();
            Object value = entry.getValue();
            criteriaString = criteriaString + key.toString() + "="
                    + value.toString();
            if (criteria.size() > counter) { criteriaString = criteriaString + ","; }
    }
        criteriaString = criteriaString + ")]";
        return criteriaString;
    }

    public String[] getStringMapping(){
        String[] mapping = new String[criteria.size()];
        int i = 0;
        for (Map.Entry<E, Object> entry : criteria.entrySet()) {
            mapping[i] = entryToString(entry);
            i++;
        }
        return mapping;
    }

    public static <E> String entryToString(Map.Entry<E, Object> entry){
        StringBuilder entryString = new StringBuilder();
        entryString.append(entry.getKey());
        entryString.append('=');
        entryString.append(entry.getValue());
        return entryString.toString();
    }

}
