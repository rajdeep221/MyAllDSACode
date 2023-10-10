package BitwiseOperator;

public class FindRightMostSetbit {

    static int rightMostSetBit(int n) {
        return n & (-n);
    }

    public static void main(String[] args) {
        System.out.println(rightMostSetBit(154));
    }
}
