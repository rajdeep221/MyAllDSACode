package String;

public class CounNumofHomoSubstr {

    public int countHomogenous(String s) {
        long count = 0;
        long temp = 0;

        char ch = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (count == 0) {
                count = 1;
            } else if (c == ch) {
                temp++;
                count += temp + 1;
            } else {
                ch = c;
                temp = 0;
                count += 1;
            }
        }
        count = count % 1000000007;
        return (int) count;
    }

    public static void main(String[] args) {
        CounNumofHomoSubstr ob = new CounNumofHomoSubstr();
        System.out.println(ob.countHomogenous("abbcccaa"));
    }
}
