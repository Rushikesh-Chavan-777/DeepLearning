public class InvertBinaryTree {


    //invert a binary tree
    public static MaximumDepthOfBinaryTree.TreeNode invertTree(MaximumDepthOfBinaryTree.TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        if(root.right == null && root.left == null) {
            return root;
        }else if(root.left == null || root.right == null) {
            return root;
        }
        MaximumDepthOfBinaryTree.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

    }



}
