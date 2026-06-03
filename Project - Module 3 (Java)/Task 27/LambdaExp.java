import java.util.*;

public class LambdaExp {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("viswa");
        a.add("rama vevi");
        a.add("raja shekar chary");
        a.add("rama shiva sai chary");
        Collections.sort(a , (x, y) ->  (x+y).compareTo(y+x));
        System.out.println("Sorted Array is : " + a);
    }
}
