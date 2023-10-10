package Recursion.Problems;

public class ReverseString {

    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    private void reverseString(char s[], int f, int l) {

        if (f >= l) {
            return;
        }
        char temp = s[f];
        s[f] = s[l];
        s[l] = temp;
        reverseString(s, f + 1, l - 1);
    }
}
