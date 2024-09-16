import java.util.*;

public class CourseSchedule1 {


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        //create the graph variable
        List<Integer>[] graph = new List[numCourses];
        //initialise all the arraylists inside the array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        //populate the graph and maintain the correct order because at the end, the graph is perfectly directed.
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
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                boolean cycle = isCyclicUtil(graph, i, vis, new boolean[vis.length]);
                if(cycle) {
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


    public static void main(String[] args) {
    }
}
