import java.util.*;
public class TryCatch {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number : ");
        int a = sc.nextInt();
        System.out.println("Enter Second number : ");
        int b = sc.nextInt();
        try {
            int d =a/b;
            System.out.println("Division is " + d);
        }catch(ArithmeticException e) {
            System.out.println("Division by Zero");
        }
    }
       
}
