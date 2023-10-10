package BinarySearchTree;

import java.util.ArrayList;

public class BST {

    private class Node {
        private int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    // Insertion in the tree

    public void intsertion(int val) {
        root = insert(val, root);
    }

    private Node insert(int val, Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.val > val) {
            // left shift
            root.left = insert(val, root.left);
        } else {
            // right shift
            root.right = insert(val, root.right);
        }

        return root;
    }

    // In-Order traversal

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // Deletion of Node by value

    public void deleteByVal(int val) {
        root = delete(root, val);
    }

    private Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            root.left = delete(root.left, val);
        } else if (root.val < val) {
            root.right = delete(root.right, val);
        } else {
            // root.val == val
            // case 1

            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2

            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // case 3

            Node IS = inOrderSuccessor(root.right, val);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }
        return root;
    }

    private Node inOrderSuccessor(Node root, int val) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print all the nodes that lies between X and Y

    public void printRange(int X, int Y) {
        printInRange(root, X, Y);
    }

    private void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }

        if (root.val >= X && root.val <= Y) {

            printInRange(root.left, X, Y);
            System.out.print(root.val + " ");
            printInRange(root.right, X, Y);

        } else if (root.val >= Y) {

            printInRange(root.left, X, Y);

        } else {

            printInRange(root.right, X, Y);
        }
    }

    // Print all the nodes from root to leaf

    public void printRoot2Leaf() {
        ArrayList<Integer> path = new ArrayList<>();
        printRoot2Leaf(root, path);
    }

    private void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            System.out.println(path.toString());
        } else {
            if (root.left != null) {
                printRoot2Leaf(root.left, path);
            }
            if (root.right != null) {
                printRoot2Leaf(root.right, path);
            }
        }
        path.remove(path.size() - 1);
    }
}
