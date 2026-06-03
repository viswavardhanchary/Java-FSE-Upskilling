import java.util.*;
public  class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number : ");
        int a = sc.nextInt();
        System.out.println("Enter second number : ");
        int b = sc.nextInt();
        sc.nextLine();
        System.out.println("Choose Operator: +\n-\n*\n/");
        String s = sc.nextLine();
        switch(s) {
            case "+": System.out.println("Add " + a + " and " + b + " = " + (a+b)); 
            break;
            case "-": System.out.println("Subtract " + a + " and " + b + " = " + (a-b)); 
            break;
            case "*": System.out.println("Multiply " + a + " and " + b + " = " + (a*b)); 
            break;
            case "/": System.out.println("Divide " + a + " and " + b + " = " + (a/b)); 
            break;
            default : System.out.println("Operator not found");
        }
    }
}
