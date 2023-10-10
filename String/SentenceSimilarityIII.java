package String;

public class SentenceSimilarityIII {

    public boolean check(String s1, String s2) {
        String arr1[] = s1.split(" ", 0);
        String arr2[] = s2.split(" ", 0);

        int l1 = arr1.length;
        int l2 = arr2.length;

        int i = 0;
        int j1 = arr1.length - 1;
        int j2 = arr2.length - 1;

        while (l1 != 0 && l2 != 0 && arr1[i].equals(arr2[i])) {
            i++;
            l1--;
            l2--;
        }

        while (l1 != 0 && l2 != 0 && arr1[j1].equals(arr2[j2])) {
            j1--;
            j2--;
            l1--;
            l2--;
        }

        return l1 == 0 || l2 == 0;
    }

    public static void main(String[] args) {
        SentenceSimilarityIII ob = new SentenceSimilarityIII();
        String s1 = "Eating right now";
        String s2 = "Eating";
        System.out.println(ob.check(s1, s2));
        System.out.println(s1.indexOf('a'));
    }
}
