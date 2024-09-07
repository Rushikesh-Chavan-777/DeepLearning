public class ValidBinarySearchTree {

    public static boolean isValidBST(BinarySearch.TreeNode root) {
        return real_isValidBST(root, null, null);
    }

    public static boolean real_isValidBST(BinarySearch.TreeNode root, BinarySearch.TreeNode minimum, BinarySearch.TreeNode maximum) {
        if (root == null) {
            return true;
        }
        if (minimum != null && root.val <= minimum.val) {
            return false;
        }
        if (maximum != null && root.val >= maximum.val) {
            return false;
        }
        return real_isValidBST(root.left, minimum, root) && real_isValidBST(root.right, root, maximum);
    }



}
