package Recursion.Problems;

public class FindMinMax {
    public static int findMinRec(int arr[], int n) {
        if (n < 1) {
            return arr[0];
        }

        return Math.min(arr[n - 1], findMinRec(arr, n - 1));
    }

    public static int findMaxRec(int arr[], int n) {
        if (n < 1) {
            return arr[0];
        }

        return Math.max(arr[n - 1], findMaxRec(arr, n - 1));
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 45, 6, -50, 10, 2 };
        int n = arr.length;
        System.out.println(findMinRec(arr, n));
        System.out.println(findMaxRec(arr, n));
    }
}
