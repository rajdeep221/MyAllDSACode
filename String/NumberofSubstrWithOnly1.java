package String;

public class NumberofSubstrWithOnly1 {

    public int numSub(String s) {
        long count = 0;

        long num = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                num++;
            }

            else if (ch == '0' && num != 0) {
                count += findSub(num);
                num = 0;
            }
        }

        if (num != 0) {
            count += findSub(num);
        }

        count = count % (1000000007);

        return (int) count;
    }

    private long findSub(long n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        NumberofSubstrWithOnly1 ob = new NumberofSubstrWithOnly1();
        System.out.println(ob.numSub("111111"));
    }
}
