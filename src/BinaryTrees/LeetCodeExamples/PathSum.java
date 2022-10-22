package BinaryTrees.LeetCodeExamples;

public class PathSum {


    //Definition for a binary tree node.
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

    public static boolean hasPathSum(TreeNode root, int targetSum) {
          if(root == null) return false;
          if(root.right == null && root.left == null && targetSum - root.val == 0) return true;
          int current = root.val;
          return hasPathSum(root.right, targetSum - current) || hasPathSum(root.left, targetSum - current);
    }


    public static void main(String[] args) {
          TreeNode root = new TreeNode(5);
          root.left = new TreeNode(4);
          root.right = new TreeNode(8);
          root.left.left = new TreeNode(11);
          root.left.left.left = new TreeNode(7);
          root.left.left.right = new TreeNode(2);
          root.right.left = new TreeNode(13);
          root.right.right = new TreeNode(4);
          root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));

    }
}
