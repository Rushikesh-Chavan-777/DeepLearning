import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    //List<List<Integer>>
    public static List<List<Integer>> levelOrder(MaximumDepthOfBinaryTree.TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();


        if(root == null){
            return list;
        }
        Queue<MaximumDepthOfBinaryTree.TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);


        List<Integer> curr_level = new ArrayList<>();

        while(!q.isEmpty()){

            MaximumDepthOfBinaryTree.TreeNode curr = q.remove();
            if(curr == null) {
                System.out.println();
                list.add(curr_level);
                curr_level = new ArrayList<>();
                if(q.isEmpty()) {
                    break;
                }else {
                    q.add(null);
                }
            }else{
                System.out.print(curr.val+" ");
                curr_level.add(curr.val);
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
