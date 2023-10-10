package Recursion.Problems;

import java.util.Arrays;

public class RemoveDublicate {

    public String removeConsecutiveDublicateCharacter(String up, String p) {
        if (up.length() == 0) {
            return p;
        }

        char ch1 = up.charAt(0);

        if (p.length() != 0 && ch1 == p.charAt(p.length() - 1)) {
            return removeConsecutiveDublicateCharacter(up.substring(1), p);
        }

        return removeConsecutiveDublicateCharacter(up.substring(1), p + ch1);
    }

    public static void main(String[] args) {
        RemoveDublicate ob = new RemoveDublicate();
        System.out.println(ob.removeConsecutiveDublicateCharacter("abbaddaaaccga", ""));

        char ch = 'A';
        int n = 7;
        char ch2 = (char) (n + '0');
        int n1 = (ch2 - '0');

        char ch1 = (char) (ch + 1);
        System.out.println(ch1 + " " + ch2 + " " + n1);
    }
}
