package StackAndQueue.ImportQuestion;

import java.util.*;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        val = Math.min(val, min.isEmpty() ? val : min.peek());

        min.push(val);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack ob = new MinStack();
        ob.push(-2);
        ob.push(0);
        ob.push(-3);
        System.out.println(ob.getMin());

    }
}
