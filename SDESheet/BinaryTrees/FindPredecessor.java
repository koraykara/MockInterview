package SDESheet.BinaryTrees;

public class FindPredecessor {

    static class BST {
        public int value;
        public BST left;
        public BST right;
        public BST parent;



        public BST(int value, BST parent) {
            this.value = value;
        }
    }

    public static BST findPredecessor(BST root, BST node){
        BST succ = null;
        while (root != null){
            if(root.value >= node.value){
                root = root.left;
            }
            else{
                succ = root;
                root = root.right;
            }
        }
        return succ;
    }

    public static BST findPredecessorWithParent(BST root, BST node){
        if(node.left != null) {
            BST cur = node.left;
            while (cur.right != null){
                cur = cur.right;
            }
            return cur;
        }
        BST cur = node.parent;
        if(cur.right == node){
            return cur;
        }
        if(cur.left == node){
            while (cur.right != null){
                cur = cur.parent;
            }
            return cur;
        }
        return null;
    }

    public static void main(String[] args) {
        BST root = new BST(10,null);
        root.left = new BST(5, root);
        root.left.left = new BST(2,root.left);
        root.left.left.left = new BST(1,root.left.left);
        root.left.right = new BST(5,root.left);
        root.right = new BST(15,root);
        root.right.left = new BST(13,root.right);
        root.right.left.right = new BST(14,root.right.left);
        root.right.right = new BST(22,root.right);
        System.out.println(findPredecessor(root, root.right).value);
    }
}
