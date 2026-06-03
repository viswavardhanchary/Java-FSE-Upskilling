import java.util.*;
import java.io.*;
public class FileReading {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String line  = br.readLine();
            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        }catch(Exception e) {
            System.out.println("Error in Writting Content");

        }
       
    }
}

