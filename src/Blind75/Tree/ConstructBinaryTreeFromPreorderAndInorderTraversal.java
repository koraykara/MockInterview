package Blind75.Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //  Definition for a binary tree node.
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart >= inEnd || preStart >= preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = findRootIndex(inorder, preorder[preStart], inStart, inEnd);
        int leftSize = rootIndex - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftSize + 1, inStart, rootIndex);
        root.right = helper(preorder, inorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }

    public static int findRootIndex(int[] inorder, int rootVal, int inStart, int inEnd) {
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode result = buildTree(preorder, inorder);
        printInOrder(result);
        System.out.println();
        printInOrder(root);
    }
}
