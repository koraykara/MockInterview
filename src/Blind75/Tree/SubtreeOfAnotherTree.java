package Blind75.Tree;

public class SubtreeOfAnotherTree {

    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        boolean result = isSameTree(root, subRoot);
        if (result) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);

        System.out.println(isSubtree(root, root2));
    }
}
