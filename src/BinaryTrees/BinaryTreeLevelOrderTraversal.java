package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
     // Definition for a binary tree node.
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> levels = new ArrayList<>();
        List<List<Integer>> levelsList = new ArrayList<>();
        if(root == null) return levelsList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levels.add(root.val);
        levelsList.add(levels);
        while(!queue.isEmpty())
        {
           levels = new ArrayList<>();
           int queueSize = queue.size();
           TreeNode current = queue.peek();
           for(int i=0;i<queueSize;i++)
           {
               if(current.left != null) {
                   queue.add(current.left);
                   levels.add(current.left.val);
               }
               if(current.right != null) {
                   queue.add(current.right);
                   levels.add(current.right.val);
               }
               queue.remove();
               current = queue.peek();
           }
           if(!levels.isEmpty())
               levelsList.add(levels);
        }
        return levelsList;
    }

    public static void main(String[] args) {
          TreeNode root = new TreeNode(3);
          root.left = new TreeNode(9);
          root.left.left = new TreeNode(111);
          root.right = new TreeNode(20);
          root.right.left = new TreeNode(15);
          root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));


    }
}
