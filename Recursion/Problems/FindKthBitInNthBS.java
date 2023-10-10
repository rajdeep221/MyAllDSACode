package Recursion.Problems;

public class FindKthBitInNthBS {

    public char findKthBit(int n, int k) {
        int cal = calculate(n, k);
        return (char) ('0' + cal);
    }

    private int calculate(int n, int k) {
        if (n == 1 || k == 1) {
            return 0;
        }

        int val = (int) Math.pow(2, n) - 1;
        int mid = val / 2;

        if (mid == k - 1) {
            return 1;
        }

        if (mid > k - 1) {
            return calculate(n - 1, k);
        }

        else {
            return calculate(n - 1, val - k + 1) ^ 1;
        }
    }

    public static void main(String[] args) {

        System.out.println((char) (0 + '0'));

    }
}
