import java.util.*;

public class Fibonnaci {
    public static int fibonnaci(int n) {
        if(n<=0) return 0;
        if(n<=2) return 1;
        
        return fibonnaci(n-1) + fibonnaci(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int a = sc.nextInt();
        System.out.println("Fibonnaci of " + a + " is " + fibonnaci(a));
    }
}
