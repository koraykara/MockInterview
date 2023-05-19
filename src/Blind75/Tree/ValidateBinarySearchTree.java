package Blind75.Tree;

import LeetcodeQuestions.BinaryTree.InvertBinaryTree;

public class ValidateBinarySearchTree {

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

    public static boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        if (root.left == null && root.right == null) return true;
        return helper(root.left, min, root.val) & helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(6);


        System.out.println(isValidBST(root));


    }
}
