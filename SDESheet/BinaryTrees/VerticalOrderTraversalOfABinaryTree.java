package SDESheet.BinaryTrees;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
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
        int level;

        public TreeInfo(TreeNode root, int col, int level) {
            this.root = root;
            this.col = col;
            this.level = level;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>(); // key: col, val: map<level, nodes>
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeInfo current = queue.remove();
                if (!treeMap.containsKey(current.col)) {
                    treeMap.put(current.col, new TreeMap<>());
                }
                if (!treeMap.get(current.col).containsKey(current.level)) {
                    treeMap.get(current.col).put(current.level, new PriorityQueue<>());
                }
                treeMap.get(current.col).get(current.level).add(current.root.val);
                if (current.root.left != null) {
                    queue.add(new TreeInfo(current.root.left, current.col - 1, current.level + 1));
                }
                if (current.root.right != null) {
                    queue.add(new TreeInfo(current.root.right, current.col + 1, current.level + 1));
                }
            }
        }
        System.out.println(treeMap);
        for (TreeMap<Integer, PriorityQueue<Integer>> map : treeMap.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : map.values()) {
                while (!nodes.isEmpty()){
                    list.add(nodes.poll());
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(verticalTraversal(root));
    }
}
