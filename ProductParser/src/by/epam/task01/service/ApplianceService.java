package by.epam.task01.service;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.criteria.Criteria;

public interface ApplianceService {
    <E>Appliance find(Criteria<E> criteria) throws Exception;
}
