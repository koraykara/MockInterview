package SDESheet.BinaryTrees;

import java.util.ArrayList;

public class FindSuccessorOfBT {

    public static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static BinaryTree findSuccessorBruteForce(BinaryTree tree, BinaryTree node) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(tree, node, list);
        for(int i=0;i<list.size();i++){
            if(list.get(i) == node.value){
                if(i+1 >= list.size()) return null;
                return new BinaryTree(list.get(i+1));
            }
        }
        return null;
    }

    public static void helper(BinaryTree tree, BinaryTree node, ArrayList<Integer> list){
        if(tree == null) return;
        helper(tree.left, node, list);
        list.add(tree.value);
        helper(tree.right, node, list);
    }

    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if(node.right != null)
            return getLeftMostNode(node);
        return getRightMostParent(node);
    }

    public static BinaryTree getLeftMostNode(BinaryTree node){
        BinaryTree currentNode = node.right;
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public static BinaryTree getRightMostParent(BinaryTree node){
        BinaryTree currentNode = node;
        while (currentNode.parent != null && currentNode.parent.right == currentNode){
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }

    public static void inorderPrint(BinaryTree tree){
        if(tree == null) return;
        inorderPrint(tree.left);
        System.out.println(tree.value);
        inorderPrint(tree.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(6);
        tree.left.right.right = new BinaryTree(7);
        tree.left.right.right.left = new BinaryTree(8);
        tree.right = new BinaryTree(3);
        System.out.println(findSuccessor(tree, tree.left).value);
        //inorderPrint(tree);
    }


}

