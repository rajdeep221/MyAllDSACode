package StackAndQueue.ImportQuestion;

import java.util.Stack;

public class MostCompSub {

    public int[] mostCompetitive(int nums[], int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && (stack.peek() > nums[i]) && ((k - stack.size()) < (nums.length - i))) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int arr[] = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }

        return arr;
    }
}
