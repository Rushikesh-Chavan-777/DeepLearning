import javax.swing.tree.TreeNode;
import java.util.*;

public class MaximumDepthOfBinaryTree {


      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
     }
    }
    static class BinaryTree{

        public static TreeNode buildTree(int nodes[], int[] idx) {
            idx[0]++;
            // Check if idx is out of bounds
            if (idx[0] >= nodes.length) {
                return null;
            }
            if (nodes[idx[0]] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx[0]]);
            newNode.left = buildTree(nodes, idx);
            newNode.right = buildTree(nodes, idx);
            return newNode;
        }

        public static TreeNode buildTree(int nodes[]) {
            int[] idx = {-1}; // Using an array to hold the index
            return buildTree(nodes, idx);
        }

        public static void printTree(TreeNode node) {
            if (node == null) {
                System.out.print("null ");
                return;
            }
            System.out.print(node.val + " ");
            printTree(node.left);
            printTree(node.right);
        }

        public static int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }

    }


    public static void main(String[] args) {

        int nodes[] = {3,9,20,-1,-1,15,7};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        tree.printTree(root);
        System.out.println();
        //maxDepth
        //System.out.println("Max depth is : " + tree.maxDepth(root));
        //sum
        //System.out.println(tree.hasPathSum(root, 1));
        //symmetric
        //System.out.println(tree.isSymmetric(root));
        //List<List<Integer>> list = tree.levelOrder(root);
        //flatten
        //tree.printTree(root);
        //tree.flatten(root);
        //tree.printTree(root);
        //sum_of_all_paths
        //System.out.println(tree.sumNumbers(root));
        Double a = 29.0;
        Double d1 = 2.0;
        System.out.println(a/d1);
        System.out.println();





    }
}
