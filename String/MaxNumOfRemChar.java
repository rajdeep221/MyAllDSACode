package String;

import java.util.Arrays;

public class MaxNumOfRemChar {
    public int maximumRemovals(String s, String p, int rem[]) {

        char chars[] = s.toCharArray();

        int low = 0, high = rem.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            for (int i = 0; i < mid; i++) {
                chars[rem[i]] = '#';
            }

            String st = newStirng(chars);

            if (isSubsequence(st, p)) {
                low = mid + 1;
            } else {
                for (int i = 0; i < mid; i++) {
                    chars[rem[i]] = s.charAt(rem[i]);
                }
                high = mid - 1;
            }
        }

        return high;
    }

    public String newStirng(char arr[]) {
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != '#') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public boolean isSubsequence(String s, String p) {
        int i = 0, j = 0;
        while (i < p.length() && j < s.length()) {
            char c = s.charAt(j);
            if (p.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == p.length();
    }

    public static void main(String[] args) {
        MaxNumOfRemChar ob = new MaxNumOfRemChar();
        int arr[] = { 3, 2, 1, 4, 5, 6 };
        System.out.println(ob.maximumRemovals("abcbddddd", "abcd", arr));
    }
}
