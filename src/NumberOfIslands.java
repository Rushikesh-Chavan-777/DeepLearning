import java.util.*;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        //initialising the variable islands which will return my final answer
        int islands = 0;
        //created a visited array to mark the lands as visited
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //running two matrices and comparing the components to see of they are connected
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return islands;
    }


    public static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[0].length || grid[i][j] == '0'|| visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j - 1, visited);
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid3 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int islands = numIslands(grid3);
        System.out.println(islands);
    }
}
