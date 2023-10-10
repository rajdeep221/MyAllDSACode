package LinkedList;

public class DoubleLinkedList {

    Node head;

    private class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");

        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public void insertLast(int val) {
        Node temp = head;

        if (head == null) {
            Node node = new Node(val, null, null);
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node(val, null, temp);
        temp.next = node;
    }

    public Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int val, int after) {
        Node temp = find(after);

        if (temp == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

}
