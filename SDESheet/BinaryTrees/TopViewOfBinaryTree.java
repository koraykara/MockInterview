package SDESheet.BinaryTrees;

import java.util.*;

public class TopViewOfBinaryTree {
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

    public static List<Integer> topViewOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeInfo current = queue.remove();
                if (!treeMap.containsKey(current.col)) {
                    treeMap.put(current.col, current.root.val);
                }
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(topViewOfBinaryTree(root));
    }
}
