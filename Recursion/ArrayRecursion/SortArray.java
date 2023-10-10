package Recursion.ArrayRecursion;

public class SortArray {

    static boolean checkSort(int arr[], int n, int s) {
        if (n - 1 > s) {
            return arr[s] <= arr[s + 1] && checkSort(arr, n, ++s);
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, 8, 9 };
        System.out.println(checkSort(arr, arr.length, 0));
    }
}
