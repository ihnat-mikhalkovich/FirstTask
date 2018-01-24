package by.epam.task01.dao.Impl;

import by.epam.task01.dao.ApplianceDAO;
import by.epam.task01.dao.util.SourceFileReader;
import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.ApplianceBuilder;
import by.epam.task01.entity.ApplianceParameterComparator;
import by.epam.task01.entity.criteria.Criteria;

import java.io.IOException;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws IOException{
        Appliance appliance = null;
        SourceFileReader sourceFileReader = SourceFileReader.getInstance();
        String line;
        while ((line = sourceFileReader.read()) != null){
            line = SourceFileReader.formatting(line);
            if (!ApplianceParameterComparator.contains(criteria, line)) {
                continue;
            }
            appliance = ApplianceBuilder.build(criteria.getApplianceType());
            String[] fieldsOfAppliance = ApplianceBuilder.creatingFields(line);
            appliance.put(fieldsOfAppliance);
            break;
        }
        return appliance;
    }

}
