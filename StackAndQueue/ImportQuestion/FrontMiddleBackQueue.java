package StackAndQueue.ImportQuestion;

import java.util.*;

public class FrontMiddleBackQueue {

    LinkedList<Integer> queue;

    public FrontMiddleBackQueue() {
        queue = new LinkedList<>();
    }

    public void pushFront(int val) {
        queue.addFirst(val);
    }

    public void pushMiddle(int val) {
        int mid = (queue.size() / 2);
        queue.add(mid, val);
    }

    public void pushBack(int val) {
        queue.addLast(val);
    }

    public int popFront() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.removeFirst();
    }

    public int popMiddle() {
        if (queue.isEmpty()) {
            return -1;
        }
        int mid = (queue.size() - 1) / 2;
        return queue.remove(mid);
    }

    public int popBack() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.removeLast();
    }

}
