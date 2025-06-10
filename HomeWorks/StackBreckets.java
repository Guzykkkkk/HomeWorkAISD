package HomeWorks;
import java.util.Stack;
public class StackBreckets {

        public static boolean valid(String str) {
            Stack<Character> stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((ch == ')' && top != '(') ||
                            (ch == '}' && top != '{') ||
                            (ch == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public static void main(String[] args) {
            String test1 = "({kl})";
            String test2 = "{[})";
            String test3 = "{[(])}";

            System.out.println("Строка \"" + test1 + "\" правильная? " + valid(test1));
            System.out.println("Строка \"" + test2 + "\" правильная? " + valid(test2));
            System.out.println("Строка \"" + test3 + "\" правильная? " + valid(test3));

        }
    }
