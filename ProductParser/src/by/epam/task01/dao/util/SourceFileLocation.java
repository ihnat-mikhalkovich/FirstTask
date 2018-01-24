package by.epam.task01.dao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SourceFileLocation {
    private static SourceFileLocation instance = new SourceFileLocation();

    private String propertiesFileLocation = "src/resources/properties.txt";

    private String sourceFileLocation;

    public static SourceFileLocation getInstance() {
        return instance;
    }

    public String getSourceFileLocation() {
        return sourceFileLocation;
    }

    private SourceFileLocation() {
        File file = new File(propertiesFileLocation);
        String line = null;
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            if ((line = bufferedReader.readLine()) != null) {
                sourceFileLocation = line;
            }
        }
        catch (IOException e) {
            sourceFileLocation = null;
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        SourceFileLocation sourceFileLocation = SourceFileLocation.getInstance();
        System.out.println(sourceFileLocation.sourceFileLocation);
    }

}
