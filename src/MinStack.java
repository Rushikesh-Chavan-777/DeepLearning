import java.util.Objects;
import java.util.Stack;

public class MinStack {


    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();  // Properly initialize the stack
        min_stack = new Stack<>();  // Initialize the min_stack (though this was already done correctly in your original code)
    }

    public void push(int val) {
        if (min_stack.isEmpty() || min_stack.peek() >= val) {
            min_stack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (Objects.equals(stack.peek(), min_stack.peek())) {
            min_stack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}
