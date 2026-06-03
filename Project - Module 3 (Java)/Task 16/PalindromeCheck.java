import java.util.*;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Sentence : ");
        StringBuilder sb = new StringBuilder(sc.nextLine());
        StringBuilder nsb =new StringBuilder();
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
                nsb.append((char)(sb.charAt(i)+32));
            }else if((sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') || (sb.charAt(i) >= '0' && sb.charAt(i) <= '9')) {
                nsb.append(sb.charAt(i));
            }
        }
        StringBuilder nnsb = new StringBuilder(nsb);
        nnsb.reverse();
        boolean flag = nnsb.toString().equals(nsb.toString());
        System.out.println("Formated String is " + nsb + " An it is " + (flag ? "Palindrome" : "not a Palindrome"));
    }
}
