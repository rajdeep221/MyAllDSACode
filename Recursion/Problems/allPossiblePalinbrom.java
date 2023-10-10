package Recursion.Problems;

import java.util.ArrayList;

public class allPossiblePalinbrom {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        findPalindrom(list, result, S);

        return result;
    }

    private static void findPalindrom(ArrayList<String> list, ArrayList<ArrayList<String>> result, String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            temp += s.charAt(i);
            if (checkPalendrom(temp)) {
                list.add(temp);
                findPalindrom(list, result, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean checkPalendrom(String s) {
        if (s.length() < 2) {
            return true;
        }

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allPalindromicPerms("nitin").toString().toString());
    }
}
