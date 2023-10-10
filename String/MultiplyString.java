package String;

import java.util.Arrays;

public class MultiplyString {
    public String multiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();

        int arr[] = new int[l1 + l2];

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i + j + 1] += mul % 10;
                arr[i + j] += mul / 10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (!(sb.isEmpty() && i == 0)) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyString ob = new MultiplyString();
        System.out.println(ob.multiply("12", "12"));
    }
}
