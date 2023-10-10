package BinaryTree.Advance;

import java.util.Scanner;

public class BinaryTree {
    private static class Node {
        private int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public BinaryTree() {

    }

    // insert elements

    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to enter left of " + node.val);
        boolean leaf = sc.nextBoolean();
        if (leaf) {
            System.out.println("Enter the value of the left of " + node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do you want to enter right of " + node.val);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    public void display() {
        display(root, " ");
    }

    private void display(Node node, String s) {
        if (node == null) {
            return;
        }
        System.out.print(s + node.val);
        display(node.left, s + "\t");
        display(node.right, s + "\t");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    public void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.println("|\t\t");
            }
            System.out.println("|-------->" + node.val);
        } else {
            System.out.println(node.val);
        }
        prettyDisplay(node.left, level + 1);
    }

}
