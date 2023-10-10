package StackAndQueue;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    public CustomStack() {
        this(DEFAULT_SIZE); // To call the constractor and set the size as default_size
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    int ptr = -1;

    public boolean push(int item) {

        if (isFull()) {
            System.out.println("Stack is fyll!!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from an empty stack!!");
        }
        return data[ptr--];
    }

    public int peek() throws StackException {
        if (isEmpty())
            throw new StackException("Can't peek from an empty stack!!");
        return data[ptr];
    }

}
