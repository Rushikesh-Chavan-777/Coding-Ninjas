import java.util.*;

public class NumberOfEnclaves {
    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int numberOfEnclaves(int[][] grid) {
        // we shall use a BFS approach here
        //creating the variables so required
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        //now traversing all columns and adding the 1's to the queue
        for(int  i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                    if(grid[i][j] == 1){
                        q.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
        //now, creating the traversal matrix for ease in the while loop
        int[] delRow = {-1, 0, +1, 0};
        int[] delColumn = {0, +1, +0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int column = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++) {
                int newRow = delRow[i] + row;
                int newColumn= delColumn[i] + column;
                if(newRow >= 0 && newRow <m &&newColumn >=0 && newColumn <n && !visited[newRow][newColumn] && grid[newRow][newColumn] == 1) {
                    visited[newRow][newColumn] = true;
                    q.add(new Pair(newRow, newColumn));
                }
            }
        }
        //now, lets traverse the entire graph one and see the count variable
        int counter = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

    }
}
