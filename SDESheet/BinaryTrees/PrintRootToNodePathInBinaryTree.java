package SDESheet.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNodePathInBinaryTree {

    // Definition for a binary tree node.
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

    public static List<Integer> getPath(TreeNode root, int node) {
        List<Integer> res = new ArrayList<>();
        if (!helper(root, node, res)) return res;
        return res;
    }

    public static boolean helper(TreeNode root, int node, List<Integer> res) {
        if (root == null) return false;
        res.add(root.val);
        if (root.val == node) return true;
        boolean left = helper(root.left, node, res);
        boolean right = helper(root.right, node, res);
        if (left || right) return true;
        res.remove(res.size() - 1);
        return false;
    }

    public static List<Integer> solve(TreeNode root, int node) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res = getPath(root, node);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        System.out.println(solve(root, 6));
    }
}
