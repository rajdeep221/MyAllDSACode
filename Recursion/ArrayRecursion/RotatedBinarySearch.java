package Recursion.ArrayRecursion;

public class RotatedBinarySearch {
    static int binarySearch(int arr[], int k, int f, int l){
        if(l < f){
            return -1;
        }
        int mid = f + (l - f) / 2;
        if(arr[mid] == k){
            return mid;
        }
        if(arr[f] <= arr[mid]){
            if(k >= arr[f] && k <= arr[mid]){
                return binarySearch(arr, k, f, mid-1);
            } else {
                return binarySearch(arr, k, mid+1, l);
            }
        }
        else if(k >= arr[mid] && k <= arr[f]){
            return binarySearch(arr, k, f, mid+1);
        }
        return binarySearch(arr, k, f, mid-1);
    }
}
