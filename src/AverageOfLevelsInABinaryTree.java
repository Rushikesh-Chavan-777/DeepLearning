import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInABinaryTree {

    public static List<Double> averageOfLevels(MaximumDepthOfBinaryTree.TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<MaximumDepthOfBinaryTree.TreeNode> q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        Double holder = 0.00;
        Double count = 0.0;
        q.add(root);


        while(!q.isEmpty()) {

            int q_size = q.size();
            holder = 0.0;
            count = 0.0;
            for(int i = 0; i < q_size; i++) {
                MaximumDepthOfBinaryTree.TreeNode curr = q.remove();
                holder = holder + curr.val;
                count++;

                if(i == q_size-1) {
                    list.add(holder/count);
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
