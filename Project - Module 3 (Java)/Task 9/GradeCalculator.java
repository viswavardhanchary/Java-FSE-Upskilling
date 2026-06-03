import java.util.*;

public class GradeCalculator {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Marks : ");
        int a = sc.nextInt();
        if(a>=90) {
            System.out.println("Grade A");
        }else if(a>=80){
            System.out.println("Grade B");
        }else if(a>=70){
            System.out.println("Grade C");
        }else if(a>=60){
            System.out.println("Grade D");
        }else {
            System.out.println("Grade Fail");
        }
       
    }
}
