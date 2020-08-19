import java.util.Scanner;
import java.util.Stack;

public class KiemTraDauNgoac {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String str4="s * (s – a) * s – b) * (s – c)";
        String str5="(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        boolean answer = check(stack, str4);
        if (answer) {
            System.out.println("Well");
        } else {
            System.out.println("NO");
        }

        answer = check(stack, str5);
        if (answer) {
            System.out.println("Well");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean check(Stack<Character> stack, String str) {

        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (sym == '(') stack.push('(');
            else if (sym == ')') {
                if (stack.empty()) return false;
                else {
                    char left = stack.peek();
                    if (left == sym) return false;
                    else stack.pop();
                }
            }
        }

        return stack.empty();
    }
}
