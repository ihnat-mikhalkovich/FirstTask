package by.epam.task01.service.validation;

import by.epam.task01.entity.criteria.Criteria;

import java.util.Map;

public class Validator {
    public static <E>boolean criteriaValidator(Criteria<E> criteria){
        if (criteria == null)
            return false;
        Map<E, Object> records = criteria.getCriteriaHashMap();
        for (Map.Entry<E, Object> entry : records.entrySet()) {
            Object value = entry.getValue();
            if ("".equals(value)) return false;
        }
        return true;
    }
}
