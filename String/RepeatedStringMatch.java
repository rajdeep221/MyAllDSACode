package String;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        String copyA = a;
        int count = 1;
        int repete = b.length() / a.length();

        for (int i = 0; i < repete + 2; i++) {
            if (a.contains(b)) {
                return count;
            } else {
                a = a + copyA;
                count++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch ob = new RepeatedStringMatch();
        System.out.println(ob.repeatedStringMatch("aabaa", "aaab"));
    }
}
