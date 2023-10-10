package Recursion.Problems;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        return (n & 1) == 1 ? false : isPowerOfTwo(n >> 1);
    }
}
