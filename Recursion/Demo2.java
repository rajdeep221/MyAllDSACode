package Recursion;
//palendrom
import java.util.Scanner;

public class Demo2 {

    static int reverANumber(int n, int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem * (int)Math.pow(10, digits-1) + reverANumber(n/10, digits-1);
    }

    static boolean palindromNumber(int n, int digits){
        return n == reverANumber(n, digits);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int digits = (int) Math.log10(n) + 1;
        System.out.println(palindromNumber(n, digits));
        sc.close();
    }
}
