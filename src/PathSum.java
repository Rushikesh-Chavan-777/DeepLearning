public class PathSum {

    static int sum = 0;
    public static boolean hasPathSum(MaximumDepthOfBinaryTree.TreeNode root, int target) {

        if(root == null && sum == target ) {
            return true;
        }else if (root == null && sum != target) {
            return false;
        }
        sum = sum + root.val;
        boolean left = hasPathSum(root.left, target);
        boolean right = hasPathSum(root.right, target);
        if(left || right) {
            return true;
        }else{
            sum = sum - root.val;
            return false;
        }
    }
}
