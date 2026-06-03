import java.util.*;
public class ArrayListEx {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Names of Users\nType Exit to stop entering");
        String name  = null;
        ArrayList<String> a = new ArrayList<>();
        do {
            System.out.println("Enter a name : ");
            name = sc.nextLine();
            a.add(name);
        }while(!name.equals("Exit"));
       System.out.println("Entered Names are  : " + a);
    }
}
