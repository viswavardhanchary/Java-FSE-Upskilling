import java.util.*;
public class ArraysSumAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  length : ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " Elements ");
        int a[] = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        System.out.println("Sum of Element is : " + sum);
        System.out.println("Average of Element is : " + ((double)sum/n));
       
    }
}
