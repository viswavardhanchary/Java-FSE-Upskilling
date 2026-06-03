import java.util.*;
import java.io.*;
public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a data : ");
        String s = sc.nextLine();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write(s);
            bw.newLine();
            System.out.println("Content is Written");
            bw.flush();
        }catch(Exception e) {
            System.out.println("Error in Writting Content");

        }
       
    }
}

