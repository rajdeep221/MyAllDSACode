package StackAndQueue.ImportQuestion;

import java.util.*;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement(int num1[], int num2[]) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> loc = new HashMap<>();

        for (int num : num2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                loc.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < num1.length; i++) {
            num1[i] = loc.getOrDefault(num1[i], -1);
        }
        return num1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

    }
}
