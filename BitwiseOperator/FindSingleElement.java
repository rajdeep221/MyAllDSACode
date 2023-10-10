package BitwiseOperator;

public class FindSingleElement {

    static int singleElement(int arr[], int n) {
        int single = 0;
        for (int i = 0; i < n; i++) {
            single = single ^ arr[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 2, 1, 5, 3, 3 };
        System.out.println(singleElement(arr, arr.length));
    }
}
