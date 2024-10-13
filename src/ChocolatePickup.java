import java.util.*;

public class ChocolatePickup {
    public static int recurseMinChocolates(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp){
        //first of all writing the edge case
        if(j1 >= m || j1 < 0 || j2 < 0 || j2 >= m) {
            return (int) Math.pow(-10, 9);
        }
        //writing the base case
        if(i == n-1) {
            //if both are on same block of the grid
            if(j1 == j2) {
                //return only one grid
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        //writing the memoization case
        if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int maxi = Integer.MIN_VALUE;
        //now writing the case for all other cases
        for(int d1 = -1; d1<= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                int ok;
                //case when they are at the same grid
                if(j1 == j2) {
                    ok = grid[i][j1] + recurseMinChocolates(i+1, j1+d1, j2+d2, n, m, grid, dp);
                }else{//case when they are on different grids
                    ok = grid[i][j1] + grid[i][j2] + recurseMinChocolates(i+1, j1+d1, j2+d2, n, m, grid, dp);
                }
                maxi = Math.max(maxi, ok);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for(int[][] row1 : dp) {
            for(int[] row2: row1){
                Arrays.fill(row2, -1);
            }
        }
        return recurseMinChocolates(0, 0, c-1, r, c, grid, dp);
    }
    public static void main(String[] args) {

        int matrix[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        // Call the maximumChocolates function and print the result
        System.out.println(maximumChocolates(n, m, matrix));

    }
}
