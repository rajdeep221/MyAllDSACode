package Recursion.Problems;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int arr[], int tar) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        getSum(list, result, arr, tar, 0);
        return result;
    }

    private void getSum(List<Integer> list, List<List<Integer>> result, int arr[], int tar, int curr) {
        if (tar == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (tar < 0) {
            return;
        }

        for (int i = curr; i < arr.length; i++) {
            list.add(arr[i]);
            getSum(list, result, arr, tar - arr[i], i);
            list.remove(list.size() - 1);
        }
    }

}
