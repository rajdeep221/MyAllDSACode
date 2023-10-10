package BitwiseOperator;

public class NthMagicNo {

    static int findNthMagicNumber(int n) {
        int r, sum = 0, i = 1;
        while (n != 0) {
            r = n & 1;
            n >>= 1;
            sum += r * Math.pow(5, i);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Magic number " + findNthMagicNumber(3));
    }
}
