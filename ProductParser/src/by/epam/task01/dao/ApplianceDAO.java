package by.epam.task01.dao;

import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.criteria.Criteria;

import java.io.IOException;
import java.util.ArrayList;

public interface ApplianceDAO {
    <E> Appliance find(Criteria<E> criteria) throws IOException;
}
