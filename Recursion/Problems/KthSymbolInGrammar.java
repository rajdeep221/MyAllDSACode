package Recursion.Problems;

public class KthSymbolInGrammar {

    private int getVal(int n, int k) {
        if (n == 1 || k == 1) {
            return 0;
        }
        int len = (int) (Math.pow(2, n - 1));

        if (k <= (len / 2)) {
            return getVal(n - 1, k);
        } else {
            return getVal(n - 1, k - (len / 2)) ^ 1;
        }
    }

}