package by.tc.task01.dao.util;

public class SourceFileEditor {

    public static String formatting(String line) {
        return line.replace(";", "").replace(",", "").replace(":", "");
    }

}
