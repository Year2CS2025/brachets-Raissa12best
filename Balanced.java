import java.util.Stack;

public class Balanced {

    public static void main(String[] args) {

        String[] str = {"({[]})", "({[})", "((()))", "({)}"};

        for (String s : str) {
            System.out.println(s + " -> " + isBalanced(s));
        }
    }

    public static boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '{' || ch == '[' || ch == '(') {

                stack.push(ch);
            }

            // Closing brackets
            else if (ch == '}' || ch == ']' || ch == ')') {

                // If stack is empty
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();

                // Check matching
                if (ch == '}' && topChar != '{') return false;

                if (ch == ']' && topChar != '[') return false;

                if (ch == ')' && topChar != '(') return false;
            }
        }

        // If stack becomes empty, balanced
        return stack.isEmpty();
    }
}