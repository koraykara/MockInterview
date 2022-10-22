package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSum {

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
    public static int treeSum(TreeNode root){
        if(root == null) return 0;
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    public static int treeSumUsingBfs(TreeNode root){
        if(root == null) return  0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            sum += currentNode.val;
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }

        return sum;
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

        System.out.println(treeSum(a));
        System.out.println(treeSumUsingBfs(a));
    }
}
