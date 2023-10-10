package Recursion.Problems;

import java.util.*;;

public class GeekOnacci {

    private static int geekOnacci(int a, int b, int c, int n) {
        if (n == 1) {
            return a;
        }

        if (n == 2) {
            return b;
        }

        if (n == 3) {
            return c;
        }

        return geekOnacci(a, b, c, n - 1) + geekOnacci(a, b, c, n - 2) + geekOnacci(a, b, c, n - 3);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int a, b, c, n;
        for (int i = 0; i < no; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            n = sc.nextInt();
            System.out.println(geekOnacci(a, b, c, n));
        }
    }
}
