package BinarySearchTree.Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportantProblem {

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // Create BinaryTree From InOrder and PostOrder

    public Node buildTreeFromInOrderAndPostOrder(int in[], int post[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return helper(map, post, 0, in.length - 1, 0, post.length - 1);
    }

    private Node helper(Map<Integer, Integer> map, int post[], int inLeft, int inRight, int poLeft, int poRight) {
        if (inLeft > inRight || poLeft > poRight) {
            return null;
        }

        Node root = new Node(post[poRight]);
        int inMid = map.get(root.val);
        int inRem = inMid - inLeft;

        root.left = helper(map, post, inLeft, inMid - 1, poLeft, poLeft + inRem - 1);
        root.right = helper(map, post, inMid + 1, inRight, poLeft + inRem, poRight - 1);
        return root;
    }

    // Create Binary Tree From InOrder and PreOrder

    public Node buildTreeFromInOrderAndPreOrder(int in[], int pre[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return getTree(pre, 0, in.length - 1, 0, pre.length - 1, map);
    }

    private Node getTree(int pre[], int inLeft, int inRight, int preLeft, int preRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        Node root = new Node(pre[preLeft]);
        int inMid = map.get(root.val);
        int inRem = inMid - inLeft;

        root.left = getTree(pre, inLeft, inMid - 1, preLeft + 1, preRight + inRem, map);
        root.right = getTree(pre, inMid + 1, inRight, preLeft + inRem + 1, preRight, map);

        return root;
    }

    // Valid Binary Search Tree

    public boolean isValidBST(Node root) {
        return isCheck(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    public boolean isCheck(Node root, long lb, long ub) {
        if (root == null) {
            return true;
        }

        if ((root.val > lb && root.val < ub) && isCheck(root.left, lb, root.val) && isCheck(root.right, root.val, ub)) {
            return true;
        }

        return false;
    }

    // Recover

    private Node first, sec, prev;

    public void recoverTree(Node root) {
        helper(root);
        swip(first, sec);
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            sec = root;
        }

        prev = root;

        helper(root.right);
    }

    private void swip(Node node1, Node node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    // Convert Sorted Array to Binary Search Tree

    public Node sortedArrayToBST(int nums[]) {
        return createBST(nums, 0, nums.length - 1);
    }

    private Node createBST(int nums[], int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        Node root = new Node(nums[mid]);
        root.left = createBST(nums, l, mid - 1);
        root.right = createBST(nums, mid + 1, r);
        return root;
    }

    // Convert Sorted List to Binary Search List

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new Node(head.val);
        }

        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node root = new Node(slow.next.val);
        root.right = sortedListToBST(slow.next.next);
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }

    // Is Complete Binary Tree

    public boolean isBalanced(Node root) {
        int lh;
        int rh;

        if (root == null) {
            return true;
        }

        lh = height(root.left);
        rh = height(root.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        long n = (long) Integer.MAX_VALUE + 1;
        System.out.println(n);
    }
}