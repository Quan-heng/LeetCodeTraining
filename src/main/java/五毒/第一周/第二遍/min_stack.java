package 五毒.第一周.第二遍;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> valueStack;

    public MinStack() {
        minStack = new Stack();
        valueStack = new Stack();
    }

    public void push(int val) {
        valueStack.push(val);
        if (minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
