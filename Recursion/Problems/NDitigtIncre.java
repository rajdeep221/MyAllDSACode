package Recursion.Problems;

import java.util.ArrayList;

public class NDitigtIncre {

    static ArrayList<Integer> increasingNumber(int N) {
        int i = getInitial(N, N > 1 ? 1 : 0);
        int n = getFinal(N, 9);
        ArrayList<Integer> ans = new ArrayList<>();

        for (; i <= n; i++) {
            if (isValid(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static int getInitial(int n, int i) {
        if (n == 1) {
            return i;
        }

        return (int) Math.pow(10, n - 1) * i + getInitial(n - 1, i + 1);
    }

    private static int getFinal(int n, int i) {
        if (n == 1) {
            return i;
        }

        return i + getFinal(n - 1, i - 1) * 10;
    }

    private static boolean isValid(int i) {
        int n1, n2;
        while (i > 9) {
            n1 = i % 10;
            n2 = i % 100;
            n2 = n2 / 10;
            if (n1 <= n2)
                return false;
            i /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(increasingNumber(2).toString());
    }
}
