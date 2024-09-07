import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {



    public static List<List<Integer>> zigzagLevelOrder(MaximumDepthOfBinaryTree.TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<MaximumDepthOfBinaryTree.TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean odd = false;
        q.add(root);
        while(!q.isEmpty()){
            odd = !odd;
            List<Integer> holder = new ArrayList();
            int q_size = q.size();
            for(int i = 0; i < q_size; i++) {
                MaximumDepthOfBinaryTree.TreeNode curr = q.remove();
                holder.add(curr.val);

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }


            }
            if(odd == false) {
                Collections.reverse(holder);
            }
            list.add(holder);

        }
        return list;
    }





}
