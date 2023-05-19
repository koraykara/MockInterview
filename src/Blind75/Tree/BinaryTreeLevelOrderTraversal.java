package Blind75.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        result.add(temp);
        while (!queue.isEmpty()){
            temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode current = queue.remove();
                if(current.left != null){
                    queue.add(current.left);
                    temp.add(current.left.val);
                }
                if(current.right != null){
                    queue.add(current.right);
                    temp.add(current.right.val);
                }
            }
            if(temp.size() != 0) {
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(100);
        root.left.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));

    }
}
