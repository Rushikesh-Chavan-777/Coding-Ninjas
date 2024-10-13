import java.util.*;

public class MinimumPathSum {
    //using recursion approach
    public static int recurseMinPathSum(int i, int j, int[][] grid, int[][] dp) {

        //writing the base case
        if(i == 0 && j == 0) {
            dp[i][j] = grid[0][0];
        }
        if(i < 0 || j < 0 ) {
            return (int) Math.pow(10, 9);
        }
        //writing the memoization case
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        //writing the general case for all other paths
        int up = grid[i][j] + recurseMinPathSum(i-1, j, grid, dp);
        int left = grid[i][j] + recurseMinPathSum(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
    public static int minSumPath(int[][] grid) {
        //making the dp array for memoization
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return recurseMinPathSum(grid.length -1, grid[0].length - 1, grid, dp);
    }
    public static void main(String[] args) {
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println(minSumPath(matrix));

    }
}
