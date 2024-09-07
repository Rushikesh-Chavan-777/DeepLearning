public class FlattenBinaryTree {

    //flatten a tree to a LinkedList
    public static void flatten(MaximumDepthOfBinaryTree.TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        MaximumDepthOfBinaryTree.TreeNode left = root.left;
        MaximumDepthOfBinaryTree.TreeNode right = root.right;


        root.left = null;
        root.right = left;
        MaximumDepthOfBinaryTree.TreeNode curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }




}
