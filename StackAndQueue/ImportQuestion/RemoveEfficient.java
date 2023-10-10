package StackAndQueue.ImportQuestion;

import java.util.Stack;

//implement queue using stack in remove efficient

public class RemoveEfficient {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public RemoveEfficient() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        first.push(item);

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() {
        return first.pop();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() throws Exception {
        return first.peek();
    }
}
