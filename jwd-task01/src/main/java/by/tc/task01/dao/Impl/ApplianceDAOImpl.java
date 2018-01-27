package by.tc.task01.dao.Impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.util.SourceFileEditor;
import by.tc.task01.dao.util.SourceFileReader;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.ApplianceBuilder;
import by.tc.task01.entity.ApplianceParameterComparator;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;

public class ApplianceDAOImpl implements ApplianceDAO {

    public <E> Appliance find(Criteria<E> criteria) throws IOException{
        Appliance appliance = null;
        SourceFileReader sourceFileReader = SourceFileReader.getInstance();
        String line;
        while ((line = sourceFileReader.read()) != null){
            line = SourceFileEditor.formatting(line);
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
