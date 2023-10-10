package Recursion.PatterQuestion;

import java.util.Arrays;

public class SelectionSort {
    static void selecion(int arr[], int r, int c, int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selecion(arr, r, c + 1, c);
            } else {
                selecion(arr, r, c + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;

            selecion(arr, r - 1, 0, 0);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 9, 7, 6, 1, 3, 8 };
        selecion(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
}
