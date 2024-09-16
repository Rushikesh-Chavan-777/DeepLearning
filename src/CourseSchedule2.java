import java.util.*;

public class CourseSchedule2 {


   /* public static boolean canFinish(int numCourses, int[][] prerequisites) {

        //create the graph variable
        List<Integer>[] graph = new List[numCourses];
        //initialise all the arraylists inside the array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //populate the graph and maintain the correct order because at the end, the graph is perfect;y directed.
        for (int[] courses : prerequisites) {
            int u = courses[0];
            int v = courses[1];
            //graph[u].add(u);
            graph[u].add(v);
        }
        //now, that its done and populated as an adjacency list.
        //so, lets get the cyclic condition checked
        //boolean cycle_param = false;

        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                boolean cycle = isCyclicUtil(graph, i, vis, new boolean[vis.length]);
                if (cycle) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isCyclicUtil(List<Integer>[] graph, int curr, boolean[] vis, boolean[] stack) {

        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            //Edge e = graph[curr].get(i);
            if (stack[graph[curr].get(i)]) { //cycle exists
                return true;
            } else if (!vis[graph[curr].get(i)] && isCyclicUtil(graph, graph[curr].get(i), vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }


    //solutions are as follows. Above code is the same as the course schedule 1 order


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) {
            return new int[0];
        }
        //create the graph variable
        List<Integer>[] graph = new List[numCourses];
        //initialise all the arraylists inside the array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //populate the graph and maintain the correct order because at the end, the graph is perfect;y directed.
        for (int[] courses : prerequisites) {
            int u = courses[0];
            int v = courses[1];
            //graph[u].add(u);
            graph[u].add(u);
        }

        //top sort
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> top_sort = new Stack<Integer>();
        top_sort = topological_sort(graph, 0, top_sort, visited);
        //return arr
        int[] arr = new int[graph.length];
        for (int i : arr) {
            arr[i] = top_sort.pop();
        }
        return arr;
    }


    public static Stack<Integer> topological_sort(List<Integer>[] graph, int curr, Stack<Integer> rec_stack, boolean[] visited) {

        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if (!visited[graph[curr].get(i)]) {
                visited[curr] = true;
                topological_sort(graph, graph[curr].get(i), rec_stack, visited);
            }
        }
        rec_stack.push(curr);
        return rec_stack;
    }*/

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the graph variable
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Populate the graph, respecting the dependency order
        for (int[] courses : prerequisites) {
            int u = courses[0], v = courses[1];
            graph[v].add(u); // v -> u means take course v before course u
        }

        // Topological sort + cycle detection
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> topSortStack = new Stack<>();

        // Try topological sort for each node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!topologicalSort(graph, i, topSortStack, visited, recStack)) {
                    return new int[0]; // Cycle detected
                }
            }
        }

        // Build the result array from the stack (topologically sorted order)
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = topSortStack.pop();
        }

        return result;
    }

    public static boolean topologicalSort(List<Integer>[] graph, int curr, Stack<Integer> stack, boolean[] visited, boolean[] recStack) {
        visited[curr] = true;
        recStack[curr] = true;

        for (int neighbor : graph[curr]) {
            if (!visited[neighbor]) {
                if (!topologicalSort(graph, neighbor, stack, visited, recStack)) {
                    return false; // Cycle detected
                }
            } else if (recStack[neighbor]) {
                return false; // Cycle detected
            }
        }

        recStack[curr] = false;
        stack.push(curr); // Add the current node to the stack in post-order
        return true;
    }



    public static void main(String[] args) {

    }
}
