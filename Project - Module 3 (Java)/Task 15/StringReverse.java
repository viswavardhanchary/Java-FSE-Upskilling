import java.util.*;
public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Sentence : ");
        StringBuilder s = new StringBuilder(sc.nextLine());
        System.out.println("Reversed String of " + s +" is " +s.reverse());
       
    }
}
