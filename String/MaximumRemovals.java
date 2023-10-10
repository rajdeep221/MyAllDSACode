package String;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumRemovals {

    static int maxRemoval(int N, int arr[], int x) {
        // code here

        int count = 0;

        return count;
    }

    public static void findSubsets(int arr[], int idx, int n, ArrayList<Integer> list, int valid, int inValid, int x) {
        if (idx == n) {

            return;
        }

        list.add(arr[idx]);
        findSubsets(arr, idx + 1, n, list, valid, inValid, x);

        list.remove(list.size() - 1);
        findSubsets(arr, idx + 1, n, list, valid, inValid, x);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        // findSubsets(arr, 0, arr.length, ans, list);
        System.out.println(ans.toString().toString());
    }
}
