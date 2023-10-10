package Recursion.DiceAndInterview;

import java.util.ArrayList;

public class LetterCombinationsOfPhoneNo {

    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        int digits = up.charAt(0) - '0';

        for (int i = (digits - 1) * 3; i < (digits * 3); i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> pad1(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        int digits = up.charAt(0) - '0';

        for (int i = (digits - 1) * 3; i < digits * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(pad1((p + ch), up.substring(1)));
        }
        return ans;

    }

    public int padCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;
        int digits = up.charAt(0) - '0';

        for (int i = (digits - 1) * 3; i < digits * 3; i++) {
            char ch = (char) ('a' + i);
            count += padCount(p + ch, up.substring(1));
        }

        return count;
    }

    public static void main(String[] args) {
        pad("", "12");
        System.out.println();
        System.out.println(pad1("", "45"));

    }
}
