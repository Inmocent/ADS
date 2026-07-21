import java.util.Scanner;
import java.util.Stack;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        String input = sc.nextLine();

        Stack<Character> store = new Stack<Character>();
        boolean a = true;

        for(int i = 0; i < input.length(); i++) {
            char b = input.charAt(i);

            if (b == '(' || b == '{' || b == '[') {
                store.push(b);
            } else if (b == ')' || b == '}' || b == ']') {
                // If we find a closing bracket but the stack is empty, it's not balanced
                if (store.isEmpty()) {
                    a = false;
                    break;
                }
                char top = store.pop();
                // If the brackets don't match, it's not balanced
                if ((b == ')' && top != '(') ||
                        (b == '}' && top != '{') ||
                        (b == ']' && top != '[')) {
                    a = false;
                    break;
                }
            }
        }
//for (char ch : input.toCharArray()){}



        if (!store.isEmpty()) {
            a = false;
        }

        if (a) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }

        sc.close();
    }
}