public class MethodOverloading {
    public static int add(int a, int b) {
        return a+b;
    }
    public static double add(double a, double b) {
        return a+b;
    }

    public static int add(int a, int b, int c) {
        return a+b+c;
    }

    public static void main(String[] args) {
        System.out.println("Function add(Integer a , Integer b) = add(2,3) = " + add(2,3));
        System.out.println("Function add(Double a , Double b) = add(2.0,3.4) = " + add(2.0,3.4));
        System.out.println("Function add(Integer a , Integer b, Integer c) = add(2,3,5) = " + add(2,3, 5));
       
    }
}
