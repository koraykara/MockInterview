package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstValues {

    // Definition for a binary tree node.
    public static class Node {
        char val;
        Node left;
        Node right;
        Node() {}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // iterative solution
    public static List<Character> depthFirstValues(Node root){
        if(root == null) return new ArrayList<>();
        List<Character> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node current = stack.pop();
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
    public static List<Character> depthFirstValuesRecursively(Node root){
        if(root == null) return new ArrayList<>();
        List<Character> leftValues = depthFirstValuesRecursively(root.left);
        List<Character> rightValues = depthFirstValuesRecursively(root.right);
        return expandList(root,leftValues,rightValues);
    }

    public static List<Character> expandList(Node root, List<Character> leftValues, List<Character> rightValues){
        ArrayList<Character> returnedList = new ArrayList<>();
        returnedList.add(root.val);
        returnedList.addAll(leftValues);
        returnedList.addAll(rightValues);
        return returnedList;
    }

    public static void main(String[] args) {

        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(depthFirstValuesRecursively(a));


    }
}
