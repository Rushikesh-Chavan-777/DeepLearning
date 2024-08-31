import java.util.*;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        //creating the stack
        Stack<Integer> stack = new Stack<>();
        //iterating the String
        for(String s: tokens) {
            switch (s) {
                case "+": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b + a);
                    break;
                }
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                case "*": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b * a);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }


}
