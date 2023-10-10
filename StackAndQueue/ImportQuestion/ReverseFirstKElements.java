package StackAndQueue.ImportQuestion;

import java.util.*;

public class ReverseFirstKElements {

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int arr[] = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = q.remove();
        }

        for (int i = k - 1; i >= 0; i--) {
            q.add(arr[i]);
        }

        int temp = 0;

        for (int i = 0; i < q.size() - k; i++) {
            temp = q.remove();
            q.add(temp);
        }

        return q;
    }
}
