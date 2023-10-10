package String;

public class MinLenofStrAfterDelSimEnd {

    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        char arr[] = s.toCharArray();

        int temp;
        while (arr[i] == arr[j] && i < j) {
            temp = arr[i];
            while (i <= j && arr[i] == temp) {
                i++;
            }

            while (i <= j && arr[j] == temp) {
                j--;
            }
        }

        return i > j ? 0 : j - i + 1;
    }

    public static void main(String[] args) {
        MinLenofStrAfterDelSimEnd ob = new MinLenofStrAfterDelSimEnd();
        System.out.println(ob.minimumLength("aabccabba"));
    }

}
