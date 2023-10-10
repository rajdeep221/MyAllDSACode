package StackAndQueue.ImportQuestion;

import java.util.*;

import javax.sql.rowset.spi.SyncResolver;

public class RemoveAllAdjacentDuplicates {

    public String remove(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == ch) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.charAt(sb.length() - 1));
    }
}
