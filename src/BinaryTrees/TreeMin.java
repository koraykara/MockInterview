package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMin {

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
    public static int treeMinUsingfDfs(TreeNode root){
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            if(currentNode.val < min){
                min = currentNode.val;
            }
            if(currentNode.left != null) stack.push(currentNode.left);
            if(currentNode.right != null) stack.push(currentNode.right);
        }
        return min;
    }

    public static int treeMinUsingfBfs(TreeNode root){
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            if(currentNode.val < min){
                min = currentNode.val;
            }
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }
        return min;
    }

    public static int treeMinRecursiveDfs(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        int leftMin = treeMinRecursiveDfs(root.left);
        int rightMin = treeMinRecursiveDfs(root.right);
        int min =  Math.min(root.val, leftMin);
        return Math.min(min, rightMin);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(treeMinUsingfDfs(a));
        System.out.println(treeMinUsingfBfs(a));
        System.out.println(treeMinRecursiveDfs(a));
    }
}
