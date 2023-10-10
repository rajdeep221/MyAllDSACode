package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST ob = new BST();
        ob.intsertion(7);
        ob.intsertion(6);
        ob.intsertion(9);
        ob.intsertion(2);
        ob.intsertion(3);
        ob.intsertion(8);
        ob.intsertion(11);

        ob.inOrderTraversal();
        System.out.println();

        ob.deleteByVal(6);
        ob.inOrderTraversal();
        System.out.println();

        ob.printRange(3, 9);
        System.out.println();

        ob.printRoot2Leaf();
    }
}
