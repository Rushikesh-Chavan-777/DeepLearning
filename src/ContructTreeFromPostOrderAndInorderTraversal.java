import java.util.HashMap;
import java.util.Map;

public class ContructTreeFromPostOrderAndInorderTraversal {


    //building tree suing inorder and post order

    public MaximumDepthOfBinaryTree.TreeNode buildTree_post_in(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inToIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; ++i)
            inToIndex.put(inorder[i], i);

        return build_post_in(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inToIndex);
    }

    MaximumDepthOfBinaryTree.TreeNode build_post_in(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
                                                    Map<Integer, Integer> inToIndex) {
        if (inStart > inEnd)
            return null;

        final int rootVal = postorder[postEnd];
        final int rootInIndex = inToIndex.get(rootVal);
        final int leftSize = rootInIndex - inStart;

        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(rootVal);
        root.left = build_post_in(inorder, inStart, rootInIndex - 1, postorder, postStart,
                postStart + leftSize - 1, inToIndex);
        root.right = build_post_in(inorder, rootInIndex + 1, inEnd, postorder, postStart + leftSize,
                postEnd - 1, inToIndex);
        return root;
    }





}
