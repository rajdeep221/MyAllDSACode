package Recursion.Problems;

import java.util.Arrays;

public class TargetSum {

    int total;

    public int findTargetSumWays(int arr[], int tar) {
        total = Arrays.stream(arr).sum();

        int memo[][] = new int[arr.length][2 * total + 1];
        for (int row[] : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return calculate(arr, 0, 0, tar, memo);
    }

    private int calculate(int arr[], int i, int sum, int tar, int memo[][]) {
        if (i == arr.length) {
            if (sum == tar) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[i][sum + total] != Integer.MAX_VALUE) {
                return memo[i][sum + total];
            }

            int add = calculate(arr, i + 1, sum + arr[i], tar, memo);
            int sub = calculate(arr, i + 1, sum - arr[i], tar, memo);
            memo[i][sum + total] = add + sub;
            return memo[i][sum + total];
        }
    }
}