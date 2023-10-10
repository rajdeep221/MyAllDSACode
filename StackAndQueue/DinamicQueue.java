package StackAndQueue;

public class DinamicQueue extends CircularQueue {

    public DinamicQueue() {
        super();
    }

    public DinamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        // this take care of it being full
        if (this.isFull()) {
            // double the array size
            int temp[] = new int[data.length * 2];

            // copy all previous itemp in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }

        // at this point we know thar arry is not full
        // insert item

        return super.insert(item);
    }
}
