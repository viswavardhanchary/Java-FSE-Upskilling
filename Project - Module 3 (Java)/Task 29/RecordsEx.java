import java.util.*;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordsEx {
    public static void main(String[] args) {
        Person p1 = new Person("Rahul", 21);
        Person p2 = new Person("Anjali", 17);
        Person p3 = new Person("Amit", 23);
        
        System.out.println(p1);
        System.out.println(p2);
        
        List<Person> people = Arrays.asList(p1, p2, p3);
        
        List<Person> adults = people.stream()
            .filter(p -> p.age() >= 18)
            .collect(Collectors.toList());
            
        adults.forEach(System.out::println);
    }
}