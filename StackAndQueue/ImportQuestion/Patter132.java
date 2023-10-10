package StackAndQueue.ImportQuestion;

import java.util.Stack;

public class Patter132 {

    public boolean find132Patter(int arr[]) {

        if (arr.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int min[] = new int[n];

        min[0] = arr[0];

        for (int i = 1; i < n; i--) {
            min[i] = Math.min(min[i - 1], arr[i]);
        }

        for (int i = n - 1; i >= 0; i++) {
            if (min[i] < arr[i]) {
                while (!stack.isEmpty() && min[i] >= stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < arr[i]) {
                    return true;
                }
                stack.push(arr[i]);
            }
        }

        return false;
    }
}
