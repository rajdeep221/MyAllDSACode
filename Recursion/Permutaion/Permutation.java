package Recursion.Permutaion;

import java.util.ArrayList;

public class Permutation {
    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + ", ");
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutations1(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutations1(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static int permutationsWithCount(String p, String up) {
        if (up.isEmpty()) {

            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsWithCount(f + ch + s, up.substring(1));
        }

        return count;
    }

    public static void main(String[] args) {
        permutations("", "abc");
        System.out.println();
        System.out.println(permutations1("", "abc").toString());
        System.out.println(permutationsWithCount("", "abc"));
    }
}