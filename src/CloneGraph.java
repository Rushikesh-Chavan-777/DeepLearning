import java.util.*;

public class CloneGraph {



//creating the Node class which will be the way all nodes of the graph are structured
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

//    ..the solution class. We shall attempt to iterate in breadth, using a modified BFS first
//    we can use a map for ease
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        //creating the arraylist we need to clone the entire graph
        List<Node> ans = new ArrayList<>();
        //creating the queue with which we are going to iterate in breadth of the graph
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        //creating the boolean array of visited
        ArrayList<Boolean> visited = new ArrayList<Boolean>();
        while (visited.size() <= node.val) {
            visited.add(false);
        }

        while(!q.isEmpty()) {
            Node curr = q.remove();
            while (visited.size() <= curr.val) {
                visited.add(false);
            }
            if(!visited.get(curr.val)) {
                ans.add(new Node(curr.val, new ArrayList<>()));
                visited.set(curr.val, true);
                for(int i = 0; i < curr.neighbors.size(); i++) {
                    //ans.get(curr.val).neighbors.add();
                    q.add(curr.neighbors.get(i));
                }
            }
        }
        return ans.get(0);
    }

    public static void main(String[] args) {
    }
}
