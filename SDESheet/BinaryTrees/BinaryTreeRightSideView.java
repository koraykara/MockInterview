package SDESheet.BinaryTrees;

import DesignDSQuestions.InsertDeleteGetRandomInO1;

import javax.management.relation.InvalidRelationTypeException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeRightSideView {

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

    // TC: O(N)
    // SC: O(H)
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    public static void helper(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(root.right, level + 1, res);
        helper(root.left, level + 1, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(rightSideView(root)); // [1,3,7,6]
    }
}
