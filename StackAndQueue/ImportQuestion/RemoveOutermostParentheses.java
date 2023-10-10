package StackAndQueue.ImportQuestion;

import java.util.*;

public class RemoveOutermostParentheses {

    public String remove(String s) {

        if (s.length() <= 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                if (open > 1) {
                    sb.append(ch);
                }
            } else {
                if (open > 1) {
                    sb.append(ch);
                }
                open--;
            }
        }

        return sb.toString();
    }
}
