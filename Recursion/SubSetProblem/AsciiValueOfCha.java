package Recursion.SubSetProblem;

import java.util.*;

//subsequence with ascii value
public class AsciiValueOfCha {

    static void subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (ch + 0), up.substring(1));
    }

    static ArrayList<String> subseqAscii1(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseqAscii1(p + ch, up.substring(1));
        ArrayList<String> secont = subseqAscii1(p, up.substring(1));
        ArrayList<String> third = subseqAscii1(p + (ch + 0), up.substring(1));
        third.addAll(first);
        third.addAll(secont);
        return third;
    }

    public static void main(String[] args) {
        subseqAscii("", "abc");
        subseqAscii1("", "abc");
    }
}
