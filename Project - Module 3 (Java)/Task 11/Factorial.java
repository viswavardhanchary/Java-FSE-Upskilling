import java.util.*;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int a = sc.nextInt();
        if(a < 0) {
            System.out.println("Pick number that is greater then or equal to 0");
        }else {
            int f = 1;
            for(int i=1;i<=a;i++) {
                f = f*i;
            }
            System.out.println("Factorial of " +a+" is " +f);
        }
       
    }
}
