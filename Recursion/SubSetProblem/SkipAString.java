package Recursion.SubSetProblem;

public class SkipAString {

    static String skip(String up) {
        if (up.isEmpty()) {
            return "";
        }

        if (up.startsWith("apple")) {
            return skip(up.substring(5));
        } else {
            return up.charAt(0) + skip(up.substring(1));
        }
    }

    public static void main(String[] args) {

    }
}
