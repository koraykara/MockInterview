package SDESheet.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RootToNodePathInBinaryTree {

    // Definition for a binary tree node.
    public static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode() {
        }

        BinaryTreeNode(int val) {
            this.data = val;
        }

        BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<BinaryTreeNode> leafs = new ArrayList<>();
        findLeafs(root, leafs);
        List<String> actualRes = new ArrayList<>();
        for (BinaryTreeNode leaf : leafs) {
            List<Integer> res = new ArrayList<>();
            boolean result = helper(root, res, leaf.data);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
                if (i != res.size()-1){
                    sb.append(" ");
                }
            }
            actualRes.add(sb.toString());
        }
        return actualRes;
    }

    public static void findLeafs(BinaryTreeNode root, List<BinaryTreeNode> leafs) {
        if (root == null) return;
        if (root.left == null && root.right == null) leafs.add(root);
        findLeafs(root.left, leafs);
        findLeafs(root.right, leafs);
    }

    public static boolean helper(BinaryTreeNode root, List<Integer> res, int val) {
        if (root == null) return false;
        res.add(root.data);
        if (root.data == val) {
            return true;
        }
        boolean checkLeft = helper(root.left, res, val);
        boolean checkRight = helper(root.right, res, val);
        if (checkLeft || checkRight) return true;
        res.remove(res.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(6);
        root.left.right.right = new BinaryTreeNode(7);
        System.out.println(allRootToLeaf(root));
    }
}
