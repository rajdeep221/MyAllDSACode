package BitwiseOperator;

public class FindBitInaParticularIndea {

    static int find(int n, int p) {
        n = n >> (p - 1);
        p = n & 1;
        return p;
    }

    public static void main(String[] args) {
        System.out.println(find(57, 1));
    }
}
