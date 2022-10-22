package BinaryTrees;

import java.util.*;

public class TreeIncludes {

    // Definition for a binary tree node.
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(char val) { this.val = val; }
        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // n = # nodes
    // Time: O(n) -> nodes are entering the queue once and leave the queue once.
    // Space: O(n) -> Because we are storing our nodes within a queue.
    // O(1) -> Remove and add operations
    public static boolean isTreeIncludesUsingBfs(TreeNode root, char target){
        boolean result = false;
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            if(currentNode.val == target) {
                result = true;
                break;
            }
            else{
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return result;
    }

    public static boolean isTreeIncludesUsingDfs(TreeNode root, char target) {
        if(root == null) return false;
        if(root.val == target) return true;
        return isTreeIncludesUsingDfs(root.left, target) || isTreeIncludesUsingDfs(root.right, target);
    }

    public static List<Character> expand(TreeNode root, List<Character> leftValues, List<Character> rightValues){
        ArrayList<Character> returnedList = new ArrayList<>();
        returnedList.add(root.val);
        returnedList.addAll(leftValues);
        returnedList.addAll(rightValues);
        return returnedList;
    }


    public static List<Character> breadFirstValues(TreeNode root){
        if(root == null) return new ArrayList<>();
        ArrayList<Character> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(  !queue.isEmpty()){
            TreeNode current = queue.remove();
            result.add(current.val);
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return result;
    }

    // iterative solution
    public static List<Character> depthFirstValues(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Character> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);

            if(current.right != null){
                stack.add(current.right);
            }
            if(current.left != null){
                stack.add(current.left);
            }
        }
        return result;
    }

    // recursive solution
    public static List<Character> depthFirstValuesRecursively(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Character> leftValues = depthFirstValuesRecursively(root.left);
        List<Character> rightValues = depthFirstValuesRecursively(root.right);
        return expandList(root,leftValues,rightValues);
    }

    public static List<Character> expandList(TreeNode root, List<Character> leftValues, List<Character> rightValues){
        ArrayList<Character> returnedList = new ArrayList<>();
        returnedList.add(root.val);
        returnedList.addAll(leftValues);
        returnedList.addAll(rightValues);
        return returnedList;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(isTreeIncludesUsingBfs(a, 'e'));
        System.out.println(isTreeIncludesUsingDfs(a, 'x'));
    }
}
