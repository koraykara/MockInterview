package SDESheet.BinaryTrees;

import AlgoExpertQuestions.Easy.FindClosestValueInBST;

public class FindSuccessorBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST findSuccessor(BST root, BST node){
        BST succ = null;
        while (root != null){
            if(root.value <= node.value){
                root = root.right;
            }
            else{
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        System.out.println(findSuccessor(root, root.left.left).value);
    }
}
