package Recursion.MazeAndBacktracking;

import java.util.ArrayList;

public class PrintThePath {

    private static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p + 'D', r - 1, c);
        }

        if (c > 1) {
            path(p + 'R', r, c - 1);
        }
    }

    private static ArrayList<String> path1(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        if (r > 1) {
            left = path1(p + 'D', r - 1, c);
        }

        if (c > 1) {
            right = path1(p + 'R', r, c - 1);
        }

        left.addAll(right);

        return left;
    }

    public static void main(String[] args) {
        path("", 3, 3);
        System.out.println(path1("", 3, 3).toString());
    }
}
