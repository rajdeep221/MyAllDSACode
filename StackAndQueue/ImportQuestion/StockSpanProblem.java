package StackAndQueue.ImportQuestion;

import java.util.Stack;

public class StockSpanProblem {

    public int[] calculateSpan(int price[], int n) {

        int arr[] = new int[price.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < price.length; i++) {
            arr[i] = 1;
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                arr[i] += arr[stack.pop()];
            }
            stack.push(i);
        }

        return arr;
    }
}
