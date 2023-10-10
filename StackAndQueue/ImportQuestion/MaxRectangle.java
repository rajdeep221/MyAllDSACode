package StackAndQueue.ImportQuestion;

import java.util.Stack;

public class MaxRectangle {

    public int maxArea(int M[][], int n, int m) {

        int ht[] = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    ht[j]++;
                } else {
                    ht[j] = 0;
                }
            }
            int area = maxAreaHistogram(ht);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int maxAreaHistogram(int ht[]) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 1; i < ht.length; i++) {
            while (!stack.isEmpty() && ht[i] < ht[stack.peek()]) {
                max = getMax(i, stack, ht, max);
            }
            stack.push(i);
        }

        int i = ht.length;

        while (!stack.isEmpty()) {
            max = getMax(i, stack, ht, max);
        }

        return max;
    }

    private int getMax(int i, Stack<Integer> stack, int ht[], int max) {
        int popped = stack.pop();
        int area;

        if (stack.isEmpty()) {
            area = ht[popped] * i;
        } else {
            area = ht[popped] * (i - 1 - stack.peek());
        }

        return Math.max(max, area);
    }
}
