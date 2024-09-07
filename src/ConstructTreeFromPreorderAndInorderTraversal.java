import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderAndInorderTraversal {

    public static MaximumDepthOfBinaryTree.TreeNode buildTree_pre_in_order(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length -1,inorder, 0, inorder.length-1, map);
    }
    public static MaximumDepthOfBinaryTree.TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
                                                          int inEnd, Map<Integer, Integer> inToIndex){

        if(preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndex = inToIndex.get(rootVal);
        int leftsize = rootIndex - inStart;

        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(rootVal);

        root.left = build(preorder, preStart, preStart + leftsize, inorder, inStart, rootIndex -1, inToIndex );
        root.right = build(preorder, preStart + leftsize +1, preEnd, inorder, rootIndex+1, inEnd, inToIndex);

        return root;
    }



}
