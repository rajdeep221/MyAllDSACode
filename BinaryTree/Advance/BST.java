package BinaryTree.Advance;

public class BST {

    public class Node {
        private int val;
        private int height;
        private Node leaf;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    private Node root;

    public BST() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String detail) {
        if (node == null) {
            return;
        }

        System.out.println(detail + node.getValue());
        display(node.leaf, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + ": ");
    }

    // Insert

    public Node insert(int val) {
        return insert(root, val);
    }

    public Node insert(Node node, int val) {

        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.val) {
            node.leaf = insert(node.leaf, val);
        }

        if (val > node.val) {
            node.right = insert(node.right, val);
        }

        node.height = Math.max(height(node.leaf), height(node.right)) + 1;

        return node;
    }

    // Check height Balenced

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.leaf) - height(node.right)) <= 1 && balanced(node.leaf) && balanced(node.right);
    }

    public void display1() {
        display1(this.root, "Root Node: ");
    }

    private void display1(Node node, String detail) {
        if (node == null) {
            return;
        }
        System.out.println(detail + node.val);
        display1(node.leaf, "Left child of " + node.val + " : ");
        display1(node.right, "Right child of " + node.val + " : ");
    }

    public void populate(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // n log(n)
    public void populateSorted(int nums[]) {
        populateSorted(nums, 0, nums.length);
    }

    public void populateSorted(int nums[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    // In-Order Traversal

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.leaf);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.leaf);
        System.err.print(node.leaf + " ");
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.leaf);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
