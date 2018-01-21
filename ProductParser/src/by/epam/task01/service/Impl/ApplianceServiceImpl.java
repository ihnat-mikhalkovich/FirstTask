package by.epam.task01.service.Impl;

import by.epam.task01.dao.ApplianceDAO;
import by.epam.task01.dao.DAOFactory;
import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.criteria.Criteria;
import by.epam.task01.service.ApplianceService;
import by.epam.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws Exception{
        if(!Validator.criteriaValidator(criteria)){
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        Appliance appliance = applianceDAO.find(criteria);

        return appliance;
    }

}