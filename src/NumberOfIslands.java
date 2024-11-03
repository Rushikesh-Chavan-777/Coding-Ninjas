import javafx.util.Pair;

import java.util.*;

public class NumberOfIslands {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void bfs(int ro, int co, char[][] grid, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        visited[ro][co] = true;
        q.add(new Pair(ro, co));
        int m = grid.length;
        int n = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // Traverse all 8 possible directions
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int newRow = row + delRow;
                    int newCol = col + delCol;

                    // Check if the new row and column are within bounds and not visited
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                            !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                        visited[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int counter = 0;

        // Traverse the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell is land and not visited, run BFS
                if (!visited[i][j] && grid[i][j] == '1') {
                    counter++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return counter;
    }


    public static void main(String[] args) {}
}
