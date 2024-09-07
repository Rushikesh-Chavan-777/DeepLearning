public class SumRootToLeafNumbers {

    //Sum Root to Leaf Numbers

    //first lets create a helper function so answer is initialised tto zero for each time the function is called
    //now, the helper function will be our actual function

    static int answer = 0;
    public static int sumNumbers(MaximumDepthOfBinaryTree.TreeNode root) {
        answer = 0;
        dfs_for_sum(root, 0);
        return answer;
    }
    //static int answer = 0;
    public static void dfs_for_sum(MaximumDepthOfBinaryTree.TreeNode root, int path) {
        if(root == null) {
            return;
        }
        path = (path * 10) + root.val;
        if(root.left == null && root.right == null) {
            answer += path;
            return;
        }
        dfs_for_sum(root.left, path);
        dfs_for_sum(root.right, path);

        return;
    }
}
