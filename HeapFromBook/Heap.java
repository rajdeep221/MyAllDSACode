package HeapFromBook;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    private static final int CAPACITY = 30;
    private int size;
    private int arr[];
    private boolean isMin;

    public Heap(int arr1[], boolean isMin) {
        this.isMin = isMin;
        size = arr1.length;
        this.isMin = isMin;

        for (int i = size / 2; i >= 0; i--) {
            proclameDown(i);
        }

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new IllegalStateException("The heap is empty");
        }
        return arr[0];
    }

    private boolean compare(int arr[], int f, int s) {
        if (isMin) {
            return arr[f] < arr[s];
        }

        return arr[f] > arr[s];
    }

    public void proclameDown(int curr) {
        int left = curr * 2 + 1;
        int right = curr * 2 + 2;
        int child = -1;
        if (left < size) {
            child = left;
        }

        if (right < size && compare(arr, right, child)) {
            int temp = arr[right];
            arr[right] = arr[child];
            arr[child] = temp;
            proclameDown(child);
        }
    }

    public void proclameUp(int curr) {
        int parent = curr / 2;

        if (parent >= 0 && compare(arr, curr, parent)) {
            int temp = arr[curr];
            arr[curr] = arr[parent];
            arr[parent] = temp;
            proclameUp(parent);
        }
    }

    public void add(int val) {
        if (size == arr.length) {
            doubleSize();
        }

        arr[size++] = val;
        proclameUp(size - 1);
    }

    public int remove() {
        int val = arr[0];
        arr[0] = arr[--size];
        return val;
    }

    public void heapSort(int arr[], boolean inc) {
        Heap ob = new Heap(arr, !inc);
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - i - 1] = ob.remove();
        }
    }

    public void doubleSize() {
        int newArr[] = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public int kthSmallestUsingHeap(int arr[], int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pqueue.add(arr[i]);
        }
        int i = -1;
        int val = 0;
        while (i < k && i < arr.length) {
            val = pqueue.remove();
        }

        return val;
    }

    public int kthLargestUsingHeap(int arr[], int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            pQueue.add(arr[i]);
        }
        
        int i = 0;
        int val = 0;
        while(i < k & i < arr.length) {
            val = pQueue.remove();
        }

        return val;
    }

}
