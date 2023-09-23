package SDESheet.BinaryTrees;

import java.util.*;

public class BottomViewOfBinaryTree {

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

    public static class TreeInfo {
        TreeNode root;
        int col;

        public TreeInfo(TreeNode root, int col) {
            this.root = root;
            this.col = col;
        }
    }

    public static List<Integer> bottomViewOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeInfo current = queue.remove();
                treeMap.put(current.col, current.root.val);
                if (current.root.left != null)
                    queue.add(new TreeInfo(current.root.left, current.col - 1));
                if (current.root.right != null)
                    queue.add(new TreeInfo(current.root.right, current.col + 1));
            }
        }
        res.addAll(treeMap.values());
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        System.out.println(bottomViewOfBinaryTree(root));
    }
}
