package Blind75.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {

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

    public static int maxPathSum(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, 0);
    }

    // SONRA BAKILACAK!
    public static int helper(TreeNode root, int max, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}
