package Recursion.ArrayRecursion;

import java.util.ArrayList;

public class ArrayListReturnType {

    static ArrayList<Integer> findAllIndex(int arr[], int i, int k, ArrayList<Integer> al) {
        if (i == arr.length) {
            return al;
        }
        if (arr[i] == k) {
            al.add(i);
        }
        return findAllIndex(arr, i + 1, k, al);
    }

    // Here the array list is defined in side the method's body
    static ArrayList<Integer> findAllIndex2(int arr[], int i, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if (i == arr.length) {
            return al;
        }
        // this will contain only the result of the current step
        if (arr[i] == k) {
            al.add(i);
        }
        ArrayList<Integer> ansFromBelow = findAllIndex2(arr, i + 1, k);
        al.addAll(ansFromBelow);
        return al;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 9, 4, 2, 5, 9, 2, 6, 4, 1, 2 };
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println(findAllIndex(arr, 0, 2, al));
        System.out.println(findAllIndex2(arr, 0, 2));
    }
}
