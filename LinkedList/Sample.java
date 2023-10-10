package LinkedList;

import java.util.*;

public class Sample {

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public Node deleteByVal(int val, Node root) {
        if (root == null) {
            return root;
        }

        if (val < root.val) {
            root.left = deleteByVal(val, root.left);
        }

        else if (val > root.val) {
            root.right = deleteByVal(val, root.right);
        }

        else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            else {
                Node IS = inOrderSuccessor(root.right);
                root.val = IS.val;
                root.right = deleteByVal(IS.val, root.right);
            }
        }

        return root;
    }

    public Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public void printRange(int X, int Y, Node root) {
        if (root == null) {
            return;
        }

        if (root.val >= X && root.val <= Y) {
            printRange(X, Y, root.left);
            System.out.print(root.val + " ");
            printRange(X, Y, root.right);
        }

        if (root.val <= X) {
            printRange(X, Y, root.right);
        }

        if (root.val >= Y) {
            printRange(X, Y, root.left);
        }
    }

    public void printRoot2Leaf(Node root, ArrayList<Integer> list) {
        if (root == null) {
            System.out.println("The node is empty");
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.print(list.toString());
        } else {
            if (root.left != null) {
                printRoot2Leaf(root.left, list);
            }

            if (root.right != null) {
                printRoot2Leaf(root.right, list);
            }
        }

        list.remove(list.size() - 1);
    }
}