package StackAndQueue.ImportQuestion;

public class IncrementOperation {
    private int arr[];

    public IncrementOperation(int maxSize) {
        arr = new int[maxSize];
    }

    private int ptr = -1;

    public void push(int x) {
        if (ptr == arr.length - 1) {
            return;
        }
        arr[++ptr] = x;
    }

    public int pop() {
        if (ptr == -1) {
            return -1;
        }
        return arr[ptr--];
    }

    public void increment(int k, int val) {
        for (int i = 0; (i < arr.length) && (i < k); i++) {
            arr[i] += val;
        }
    }
}
