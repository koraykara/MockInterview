package SDESheet.BinaryTrees;

public class LCAInBinarySearchTree {

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

    // TC: O(H) where H is the height of the tree
    // SC: O(H) where H is the height of the tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int cur = root.val;
        if (p.val < cur && q.val < cur) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > cur && q.val > cur) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }
}
