package Blind75.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> big = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        big.add(temp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                    temp.add(current.left.val);
                }
                if (current.right != null) {
                    queue.add(current.right);
                    temp.add(current.right.val);
                }
                if (temp.size() != 0 && !big.contains(temp)) {
                    big.add(temp);
                }
            }
        }
        for (List<Integer> list : big) {
            int size = list.size();
            result.add(list.get(size - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(rightSideView(root));
    }
}
