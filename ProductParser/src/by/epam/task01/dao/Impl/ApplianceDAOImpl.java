package by.epam.task01.dao.Impl;

import by.epam.task01.dao.ApplianceDAO;
import by.epam.task01.entity.Appliance;
import by.epam.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws IOException{
        Appliance appliance = new Appliance();
        String pathToFile = "src\\resources\\appliances_db.txt";
        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] partsOfRequest = criteria.getStringMapping();
        String line = null;
        boolean flag = false;
        while ((line = bufferedReader.readLine()) != null){
            String[] partsOfLine = splitter(line);
            String applianceType = criteria.getApplianceType();
            if ((flag || applianceType.equals(partsOfLine[0])) && filter(partsOfLine, partsOfRequest)){
                appliance.put(partsOfLine);
                flag = true;
            }
        }
        return appliance;
    }

    private boolean filter(String[] l, String[] r) {
        int counter = 0;
        for (int i = 0; i < r.length; i++){
            for (int j = 1; j < l.length; j++) {
                r[i] = r[i].toUpperCase();
                l[j] = l[j].toUpperCase();
                if (r[i].equals(l[j]))
                    counter++;
            }
        }
        return (counter == r.length);
    }

    private String[] splitter(String line){
        return line.replace(";", "").replace(",", "").replace(":", "").split(" ");
    }

}
