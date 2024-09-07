import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingRighPointersInEachNode {


    static class TrinaryTree{



        public static MaximumDepthOfBinaryTree.TreeNode buildTree(int nodes[], int[] idx) {
            idx[0]++;
            // Check if idx is out of bounds
            if (idx[0] >= nodes.length) {
                return null;
            }
            if (nodes[idx[0]] == -1) {
                return null;
            }
            MaximumDepthOfBinaryTree.TreeNode newNode = new MaximumDepthOfBinaryTree.TreeNode(nodes[idx[0]]);
            newNode.left = buildTree(nodes, idx);
            newNode.right = buildTree(nodes, idx);
            return newNode;
        }

        public static MaximumDepthOfBinaryTree.TreeNode buildTree(int nodes[]) {
            int[] idx = {-1}; // Using an array to hold the index
            return buildTree(nodes, idx);
        }


        public static Node connect(Node root) {
            if (root == null) return null;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                // Process all nodes at the current level
                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = queue.poll();

                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                    if(i == levelSize-1) {
                        currentNode.next = null;
                    }else{
                        currentNode.next = queue.peek();
                    }
                }
                System.out.println(); // Newline after each level
            }

            // Return the root node after traversal
            return root;
        }


    }




    public static void main(String[] args) {}
}
