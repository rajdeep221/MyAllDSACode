package StackAndQueue.ImportQuestion;
//In google very famous

import java.util.*;

public class ImplementQueueUsingStack {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int remove() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int remove = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return remove;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }

    public int peek() throws Exception {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

}
