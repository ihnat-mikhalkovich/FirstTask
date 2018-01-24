package by.epam.task01.dao.util;

import java.io.*;

public class SourceFileReader implements Closeable {

    private static final SourceFileReader instance = new SourceFileReader();

    private int lineCounter = 0;

    private static final String sourceName = SourceFileLocation.getInstance().getSourceFileLocation();

    private SourceFileReader() {}

    public static SourceFileReader getInstance() {
        return instance;
    }

    @Override
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

    public static String formatting(String line) {
        return line.replace(";", "").replace(",", "").replace(":", "");
    }

    public static void main(String[] args) {
        SourceFileReader sourceFileReader = SourceFileReader.getInstance();
        try {
            System.out.println('\n' + sourceFileReader.read());
            System.out.println(sourceFileReader.read());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            sourceFileReader.close();
        }
    }

}
