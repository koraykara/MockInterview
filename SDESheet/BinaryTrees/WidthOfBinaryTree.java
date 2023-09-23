package SDESheet.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

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

    public static class Pair {
        TreeNode root;
        int width;

        public Pair(TreeNode root, int width) {
            this.root = root;
            this.width = width;
        }
    }

    // TC: O(n) where n is the number of nodes.
    // SC: O(n) where n is the number of nodes.
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int width = 0;
        if (root == null) return width;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                Pair cur = queue.remove();
                if (i == 0) first = cur.width;
                if (i == size - 1) last = cur.width;
                if (cur.root.left != null) {
                    queue.add(new Pair(cur.root.left, (cur.width - 1) * 2 + 1));
                }
                if (cur.root.right != null) {
                    queue.add(new Pair(cur.root.right, (cur.width - 1) * 2 + 2));
                }
            }
            width = Math.max(width, (last - first) + 1);
        }
        return width;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(4);

        System.out.println(widthOfBinaryTree(root));
    }
}
