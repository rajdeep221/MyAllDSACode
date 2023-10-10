package StackAndQueue;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super(); // it will call CustomStack()
    }

    public DynamicStack(int size) {
        super(size);
    }

    public boolean push(int item) {
        // this take care of it being full
        if (this.isFull()) {
            // double the array size
            int temp[] = new int[data.length * 2];

            // copy all previous itemp in new data
            System.arraycopy(data, 0, temp, 0, data.length);

            data = temp;

        }

        // at this point we know thar arry is not full
        // insert item

        return super.push(item);

    }
}
