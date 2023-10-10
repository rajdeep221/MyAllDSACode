package Recursion.Problems;

import java.util.Arrays;

public class SumTriangle {

    public void sumTriangle(int arr[]) {
        if (arr.length < 1) {
            return;
        }

        int temp[] = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            temp[i] = arr[i] + arr[i + 1];
        }
        sumTriangle(temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = { 9, 7, 2, 4 };
        SumTriangle ob = new SumTriangle();
        ob.sumTriangle(arr);
    }
}
