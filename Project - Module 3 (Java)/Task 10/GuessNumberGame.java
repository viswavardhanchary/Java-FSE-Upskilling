import java.util.*;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int our = (int) (Math.random() * (100-1+1) + 1);
        do {
            System.out.println("Enter a number : ");
            int a = sc.nextInt();
            if(a > our) {
                System.out.println("Your Pick is to high");
            } else if(a < our ) {
                System.out.println("Your Pick is to low");
            } else {
                System.out.println("Your Pick is correct");
                break;
            }
        }while(true);
       
    }
}
