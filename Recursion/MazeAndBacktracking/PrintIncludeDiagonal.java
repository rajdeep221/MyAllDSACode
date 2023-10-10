package Recursion.MazeAndBacktracking;

import java.util.ArrayList;

public class PrintIncludeDiagonal {
    static void diagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.print(p + " ");
            return;
        }

        if (r > 1 && c > 1) {
            diagonal(p + 'D', r - 1, c - 1);
        }

        if (r > 1) {
            diagonal(p + 'V', r - 1, c);
        }

        if (c > 1) {
            diagonal(p + 'H', r, c - 1);
        }

    }

    static ArrayList<String> diagonal1(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (r > 1 && c > 1) {
            ans.addAll(diagonal1(p + 'D', r - 1, c - 1));
        }

        if (r > 1) {
            ans.addAll(diagonal1(p + 'V', r - 1, c));
        }

        if (c > 1) {
            ans.addAll(diagonal1(p + 'H', r, c - 1));
        }

        return ans;

    }

    public static void main(String[] args) {
        diagonal("", 3, 3);
        System.out.println(diagonal1("", 3, 3).toString());
    }
}
