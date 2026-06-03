import java.lang.reflect.Method;

class Sample {
    public void greet(String message) {
        System.out.println("Greeting: " + message);
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Sample");
            Object obj = cls.getDeclaredConstructor().newInstance();
            
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
                System.out.println("Parameter Count: " + method.getParameterCount());
            }

            Method greetMethod = cls.getDeclaredMethod("greet", String.class);
            greetMethod.invoke(obj, "Hello via Reflection!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}