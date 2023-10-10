package StackAndQueue.ImportQuestion;

import java.util.*;

public class DeleteMiddleElement {
    public void deleteMiddleElementOfAStack(Stack<Integer> stack, int size) {

        int mid;
        if ((size & 1) == 1) {
            mid = (size + 1) / 2;
        } else {
            mid = (size / 2) + 1;
        }

        Stack<Integer> temp = new Stack<>();

        for (int i = 1; i < mid; i++) {
            temp.push(stack.pop());
        }

        stack.pop();

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
