package by.tc.task01.dao.util;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Closeable;

public class SourceFileReader implements Closeable {

    private static final SourceFileReader instance = new SourceFileReader();
    private int lineCounter = 0;
    private static final String sourceName = SourceFileLocation.getInstance().getSourceFileLocation();

    private SourceFileReader() {}

    public static SourceFileReader getInstance() {
        return instance;
    }

    public void close() {
            lineCounter = 0;
    }

    public String read() throws IOException {
        FileReader fileReader = new FileReader(sourceName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        for (int i = 0; i < lineCounter+1; i++) {
            if ((line = bufferedReader.readLine()) == null) {
                return line;
            }
        }
        lineCounter++;
        return line;
    }

}
