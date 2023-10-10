package BinaryTree;
import java.util.*;

public class DemoBinaryTree {
    private class Node {
        private int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    // Create Binary Tree O(n)

    public void createTree(int nodes[]) {
        root = buildTree(nodes);
    }

    private int idx = -1;

    private Node buildTree(int nodes[]) {
        idx++;

        if (idx >= nodes.length) {
            return null;
        }

        if (nodes[idx] == -1) {
            return null;
        }

        Node node = new Node(nodes[idx]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }

    public void printRootVal() {
        System.out.println(root.val);
    }

    // Pre Order Traversal

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In Order Traversal

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // Post Order Traversal

    private void postOreder(Node root) {
        if (root == null) {
            return;
        }
        postOreder(root.left);
        postOreder(root.right);
        System.out.print(root.val + " ");
    }

    // Level Order Traversal

    private void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node node = q.remove();
            if (node == null) {
                System.out.println();
                if (q.isEmpty()) {
                    return;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(node.val + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
    }

    // Count no. of nodes

    private int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right + 1;
    }

    // Sum of all nodes

    private int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.val;
    }

    // Height of the tree

    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Diameter of the tree

    private class TreeInfo {
        int ht;
        int dia;

        public TreeInfo(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }

    private int finalDia() {
        return diameter(root).dia;
    }

    private TreeInfo diameter(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int finalHt = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.dia;
        int diam2 = right.dia;
        int diam3 = left.ht + right.ht + 1;

        int finalDia = Math.max(diam1, Math.max(diam2, diam3));

        TreeInfo data = new TreeInfo(finalHt, finalDia);
        return data;
    }

    // Check whether the Trees are identical or not

    private boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    // Check whether the second tree is a sub tree of the first tree

    private boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // sum of the nodes at Kth level

    private int sumOfNodesAtKLevel(Node root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 0) {
            return root.val;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int i = 0;

        while (!q.isEmpty() && i < k) {
            Node node = q.remove();
            if (node == null) {
                i++;
                if (i == k || q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.remove().val;
        }

        return sum;
    }

    // Binary Tree Right Side View

    public List<Integer> rightSideView(Node root) {
        List<Integer> rightView = new ArrayList<>(100);
        setRightView(root, rightView, 0);
        return rightView;
    }

    private void setRightView(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() == level) {
            list.add(root.val);
        } else {
            list.set(level, root.val);
        }

        setRightView(root.left, list, level + 1);
        setRightView(root.right, list, level + 1);
    }

    public void setRightView1(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() == level) {
            list.add(root.val);
        }

        setRightView(root.right, list, level + 1);
        setRightView(root.left, list, level + 1);
    }

    // top-level view

    private class Pair {
        Node node;
        int hd;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair cur = q.remove();
            if (!map.containsKey(cur.hd)) {
                map.put(cur.hd, cur.node.val);
            }

            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }

            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    // Bottom View

    public List<Integer> bottomView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            map.put(curr.hd, curr.node.val);

            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }

            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    // A function to execute all the other functions

    public void callFunctions() {
        System.out.println("Preorder Traversal");
        preOrder(root);
        System.out.println();
        System.out.println("Inorder Traversal");
        inOrder(root);
        System.out.println();
        System.out.println("Postorder Traversal");
        postOreder(root);
        System.out.println();
        System.out.println("Levelorder Traversal");
        levelOrder(root);
        System.out.println("No of nodes are " + countOfNodes(root));
        System.out.println("Sum of all the nodes are " + sumOfNodes(root));
        System.out.println("Height of the tree is " + height(root));
        System.out.println("Diameter of the tree is " + finalDia());
        System.out.println("Sum of the temps at k level " + sumOfNodesAtKLevel(root, 2));
    }
}
