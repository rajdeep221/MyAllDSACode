package StackAndQueue.ImportQuestion;

import java.util.*;

public class LongestValidParentheses {

    // By using Stack in O(n)
    public int longestValidPar(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    // In space Compexity = O(1) & T(N) = O(N)

    public int longestValidPar1(String s) {
        int max = 0, left = 0, right = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, 2 * right);
            }

            if (right > left) {
                right = left = 0;
            }
        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right == left) {
                max = Math.max(max, right * 2);
            }

            if (left > right) {
                left = right = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        double d = 4.5;
        System.out.println(4 % 2);
    }
}