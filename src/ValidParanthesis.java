import java.util.*;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //iterating over the Strong s
        for(Character c : s.toCharArray()) {
            //checking for opening paranthesis
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()){
                    return false;
                }
                Character top = stack.pop();
                if(top == '(' && c == ')') {
                    return true;
                }
                if(top == '[' && c == ']') {
                    return true;
                }
                if(top == '{' && c == '}') {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean isValid1(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (final char c : s.toCharArray())
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;

        return stack.isEmpty();
    }




    public static void main(String[] args) {
        System.out.println(isValid1("(){}}{"));
    }
}
