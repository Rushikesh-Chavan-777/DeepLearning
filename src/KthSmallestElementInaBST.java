import java.util.ArrayList;

public class KthSmallestElementInaBST {

    //kth smallest element
    //using the fact that in a binary search tree, the next smallest element will always be on theleft side
    //List<List<Integer>>

    public static int kthSmallest(BinarySearch.TreeNode root, int k) {
        return help_inorder(root).get(k - 1);
    }

    public static ArrayList<Integer> help_inorder(BinarySearch.TreeNode root) {
        ArrayList<Integer> e = new ArrayList<>();
        return inorder_traversal(root, e);
    }

    public static ArrayList<Integer> inorder_traversal(BinarySearch.TreeNode root, ArrayList<Integer> e) {

        if (root == null) {
            return e;
        }
        inorder_traversal(root.left, e);
        e.add(root.val);
        inorder_traversal(root.right, e);
        return e;
    }




}
