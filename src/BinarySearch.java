import java.util.*;

public class BinarySearch {

//Defining the TreeNode
    static public class TreeNode {
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


    static class BinarySearchTree {

        //Insert Function
        public static TreeNode insert(TreeNode root, int value) {
            if (root == null) {
                root = new TreeNode(value);
                return root;
            }
            if (root.val > value) {
                root.left = insert(root.left, value);
            }
            if (root.val < value) {
                root.right = insert(root.right, value);
            }
            return root;
        }
    }

    public static void main(String[] args) {

        int values[] = {2,2,2};
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = null;
        for (int i = 0; i < values.length; i++) {
            root = tree.insert(root, values[i]);
        }


    }
}
