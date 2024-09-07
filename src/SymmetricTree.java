public class SymmetricTree {


    public static boolean isSymmetric(MaximumDepthOfBinaryTree.TreeNode root) {
        return dfs(root, root);
    }
    public static boolean dfs(MaximumDepthOfBinaryTree.TreeNode p, MaximumDepthOfBinaryTree.TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p  == null || q == null || p.val != q.val) {
            return false;
        }
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }




}
