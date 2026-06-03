import java.util.*;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Year : ");
        int a = sc.nextInt();
        if((a%4 == 0 && a%100 != 0 || (a%400 == 0))) {
            System.out.println("It is Leap Year");
        }else {
            System.out.println("It is not Leap Year");
        }
       
    }
}
