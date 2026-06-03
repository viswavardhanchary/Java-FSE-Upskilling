import java.util.*;
import java.util.stream.Collectors;

public class StreamApiEx {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        List<Integer> fil = a.stream().filter(x -> {return x%2 == 0;}).collect(Collectors.toList());
        System.out.println("Filtered List is : " + fil);
        
    }
}
