package BinaryTree;

import java.util.Scanner;

public class DemoBst {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode rigth;
        TreeNode(int data){
            this.data = data;
            this.left = this.rigth = null;
        }
    }
    TreeNode root;
    DemoBst(){
        root = null;
    }
    public TreeNode insert(TreeNode root, int dataToBeInserted){
        if(root == null){
            root = new TreeNode(dataToBeInserted);
            return root;
        }
        if(root.data > dataToBeInserted){
            root.left = insert(root.left, dataToBeInserted);
        } else if(root.data < dataToBeInserted) {
            root.rigth = insert(root.rigth, dataToBeInserted);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int dataToBeInserted){
        if(root == null || root.data == dataToBeInserted)
            return root;
        if(root.data > dataToBeInserted)
            return search(root.left, dataToBeInserted);
        return search(root.rigth, dataToBeInserted);
    }

    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.err.print(root.data+ " ");
        inOrder(root.rigth);
    }

    public void preOrder(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.rigth );
    }

    public void postOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        inOrder(root.rigth);
    }

    public void inserIntoTree(int dataToBeInserted){
        root = insert(root, dataToBeInserted);
    }

    public TreeNode searchTree(int dataToBeInserted){
        return search(root, dataToBeInserted);
    }

    public void inOrderTraversal(){
        inOrder(root);
    }

    public void preOrderTraversal(){
        preOrder(root);
    }

    public static void main(String[] args) {
        DemoBst bst = new DemoBst();
        int n, num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how may numbers to be input");
        n = sc.nextInt();
        System.out.println("Enter " + n + " numbers : ");
        for(int i=0; i<n; i++){
            num = sc.nextInt();
            bst.inserIntoTree(num);
        }
        System.err.println("Tree insetion done");

        System.out.println("Enter number to be searched");
        n = sc.nextInt();
        if(bst.searchTree(n) != null){
            System.out.println("Number found");
        } else {
            System.out.println("Number not found");
        }
        System.out.println("Inorder traversal of binary search tree");
        bst.inOrderTraversal();
        System.out.println("\nPreorder treversal of binary search tree");
        bst.preOrderTraversal();
        System.out.println("\nPostorder traversal of binary search tree");
    }
}
