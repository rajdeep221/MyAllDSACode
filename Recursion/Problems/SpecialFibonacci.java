package Recursion.Problems;

import java.util.*;

public class SpecialFibonacci {

    private int specialFibonacci(int a, int b, int n) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }

        if (n == 3) {
            return (a ^ b);
        }

        return specialFibonacci(a, b, n % 3);
    }

    public static void main(String[] args) throws java.lang.Exception {

        SpecialFibonacci ob = new SpecialFibonacci();
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();

        for (int i = 0; i < no; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(ob.specialFibonacci(a, b, n));
        }
        sc.close();

    }
}
