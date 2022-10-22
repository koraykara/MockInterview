package BinaryTrees;

public class MaxRootToLeafPathSum {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // n = # nodes
    // Time: O(n)
    // Space: O(n)
    public static int maxRootToLeaf(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right == null) return root.val;
        int leftMax = maxRootToLeaf(root.left);
        int rightMax = maxRootToLeaf(root.right);
        return root.val + Math.max(rightMax, leftMax);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(-2);
        TreeNode f = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(maxRootToLeaf(a));
    }
}
