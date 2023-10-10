package StackAndQueue.ImportQuestion;

import java.util.*;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> letter = new Stack<>();

        int idx = 0;
        String dec = "";

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int c = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    c = c * 10 + (s.charAt(idx++) - '0');
                }
                count.push(c);
            } else if (s.charAt(idx) == '[') {
                letter.push(dec);
                dec = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(letter.pop());
                int len = count.pop();

                for (int i = 0; i < len; i++) {
                    sb.append(dec);
                }

                dec = sb.toString();
                idx++;
            } else {
                dec += s.charAt(idx++);
            }
        }

        return dec;
    }

}
