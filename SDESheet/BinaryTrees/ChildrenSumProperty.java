package SDESheet.BinaryTrees;

public class ChildrenSumProperty {


    static class Node {
        public int data;
        public Node left;
        public Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean changeTree(Node root) {
        // Write your code here.
        if (root == null) return false;
        int childSum = 0;
        if (root.left != null) childSum += root.left.data;
        if (root.right != null) childSum += root.right.data;
        if (root.left != null && childSum < root.data) {
            root.left.data = root.data;
        }
        if (root.right != null && childSum < root.data) {
            root.right.data = root.data;
        }

        if (childSum >= root.data) root.data = childSum;

        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if (root.left != null) {
            total += root.left.data;
        }
        if (root.right != null) {
            total += root.right.data;
        }
        if (root.data < total) {
            root.data = total;
        }
        return true;
    }

    public static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.left.left = new Node(3);
        root.right = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        printTree(root);
        System.out.println(changeTree(root));
        printTree(root);
    }
}
