import java.util.*;
class InvalidAgeException extends Exception {
    String message() {
        return "Age is Less the 18! Not Allowes";
    }
}

public class CustomException {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int a = sc.nextInt();
        try {
            if(a < 18) {
                throw new InvalidAgeException();
            }
        }catch(InvalidAgeException e) {
            System.out.println(e.message());
        }
    }
       
}
