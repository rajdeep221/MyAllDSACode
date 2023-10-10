package BitwiseOperator;

public class APowB {

    static int powerUsingBitWise(int power, int base) {
        int ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans = ans * base;
            }
            base *= base;
            power = power >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(powerUsingBitWise(2, 5));
    }
}
