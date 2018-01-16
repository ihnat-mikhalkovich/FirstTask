import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductFilter {
    public static void main(String[] args) {
        System.out.print("Enter the request: ");
        Scanner in = new Scanner(System.in);
        String request = in.nextLine();
        String[] partsOfRequest = request.toLowerCase().split(" ");
        String filename = "appliances_db.txt";
        try(FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);){
            String line = null;
            boolean flag = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] partsOfLine = line.toLowerCase().split(" ");
                if (filter(partsOfLine, partsOfRequest)) {
                    System.out.println(line);
                    flag = true;
                }
            }
            if(!flag) System.out.println("not found");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static boolean filter(String[] l, String[] r){
        int counter = 0;
        if (l[0].equals(r[0])) {
            counter++;
            for (int i = 1; i < r.length; i++) {
                for (int j = 2; j < l.length; j++) {
                    if (r[i].equals(l[j].replace(";","").replace(",",""))) {
                        counter++;
                    }
                }
            }
        }
        return (counter == r.length);
    }
}