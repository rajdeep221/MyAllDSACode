package BitwiseOperator;

public class FindSingleNo {

    // First approach: - Here it is valid for all odd times varialable. ex: - 3, 5,
    // 7, 9
    static int repretation3Times1(int arr[], int n) {
        int sum, result = 0, i, j, x;
        for (i = 0; i < 32; i++) {
            sum = 0;
            x = (1 << i);
            for (j = 0; j < n; j++) {
                if ((arr[j] & x) != 0) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {

                result |= x;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 1, 3, 1, 5, 5 };
        System.out.println(repretation3Times1(arr, arr.length));
    }
}
