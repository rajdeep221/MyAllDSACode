package Recursion.Problems;

public class FirstUpperCase {

    static char first(String s) {
        if (s.length() <= 0) {
            return '1';
        }

        if (Character.isUpperCase(s.charAt(0))) {
            return s.charAt(0);
        }

        return first(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(first("dafkLjaldfj"));
    }
}
