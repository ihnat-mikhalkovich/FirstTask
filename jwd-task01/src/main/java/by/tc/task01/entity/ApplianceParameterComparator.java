package by.tc.task01.entity;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class ApplianceParameterComparator {

    private ApplianceParameterComparator() {}

    public static <E> boolean containsApplianceType(Criteria<E> criteria, String line){
        String applianceType = criteria.getApplianceType();
        return line.contains(applianceType);
    }

    public static <E> boolean containsEntryOfCriteria(Map.Entry<E, Object> entry, String line){
        String request = Criteria.entryToString(entry);
        return line.contains(request);
    }

    public static <E> boolean containsCriteriaFields(Criteria<E> criteria, String line){
        int overlapCounter = 0;
        Map<E, Object> criteriaMap = criteria.getCriteria(); // сомнительно использование <E, Object> ?
        for (Map.Entry<E, Object> entry : criteriaMap.entrySet()) {
            if (!ApplianceParameterComparator.containsEntryOfCriteria(entry, line)) {
                break;
            }
            overlapCounter++;
        }
        return (overlapCounter == criteriaMap.size());
    }

    public static <E> boolean contains(Criteria<E> criteria, String line){
        return containsApplianceType(criteria, line) && containsCriteriaFields(criteria, line);
    }

}
