import java.util.*;
public class HashMapEx {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ids and Names of Users\n(Ex. 1 rama)\nType Exit to stop entering");
        String name  = null;
        HashMap<Integer, String> a = new HashMap<>();
        do {
            System.out.println("Enter a name : ");
            name = sc.nextLine();
            if(name.equals("Exit")) break;
            int id = Integer.parseInt(name.split(" ")[0]);
            String fname = name.substring(name.split(" ")[0].length()+1 , name.length());
            if(id!=-1) {
                a.put(id , fname);
            }
        }while(!name.equals("Exit"));
       System.out.println("Entered List are  : " + a);
       System.out.println("Entered Id to get name  : ");
       int id = sc.nextInt();
       System.out.println("Id = " + id + " Name " + a.get(id));
    }
}
