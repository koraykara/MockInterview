package Blind75.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

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

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode removed = queue.remove();
            sb.append(removed.val).append(",");
            if(removed.left != null){
                queue.add(removed.left);
            }
            if(removed.right != null){
                queue.add(removed.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(serialize(root));
    }
}
