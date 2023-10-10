package String;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';

        int i = 0;
        char arr[] = s.toCharArray();

        while (i <= arr.length) {

            while (i < arr.length && Character.isDigit(arr[i])) {
                num = num * 10 + (arr[i] - '0');
                i++;
            }

            if (i == arr.length || (!Character.isDigit(arr[i]) && arr[i] != ' ')) {
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                operator = i == arr.length ? '+' : arr[i];
            }

            i++;
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        BasicCalculatorII ob = new BasicCalculatorII();
        System.out.println(ob.calculate(" 3+5 / 2 "));
    }
}
