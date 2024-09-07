import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSIdeView {


    //Rightside view
    public static List<Integer> rightSideView(MaximumDepthOfBinaryTree.TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<MaximumDepthOfBinaryTree.TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(root);


        while(!q.isEmpty()) {

            int q_size = q.size();
            for(int i = 0; i < q_size; i++) {
                MaximumDepthOfBinaryTree.TreeNode curr = q.remove();

                if(i == q_size-1) {
                    list.add(curr.val);
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return list;
    }
}
