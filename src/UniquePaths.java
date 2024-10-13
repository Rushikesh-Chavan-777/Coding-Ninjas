import java.util.*;

public class UniquePaths {

    //using the recursive approach first
    public static int recurseUniquePaths(int i, int j, int[][] dp){

        //tackling the base case first
        if(i == 0 && j == 0) {
            return 1;
        }
        if(i < 0 || j < 0) {
            return 0;
        }
        //memoization
        if(dp[i][j] != -1) return dp[i][j];

        //now, moving to the other recursion areas
        int up = recurseUniquePaths(i-1, j, dp);
        int left = recurseUniquePaths(i, j-1, dp);
        return up + left;
    }


    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return tabulateRecursivePaths(m, n, dp);
    }

    //now, working on the tabulation approach
    public static int tabulateRecursivePaths(int m, int n, int[][] dp) {
        //steps
        //1.base case
        //2.iterate over both grids
        //3.copy the code from recursion


        //1.creating the base case
        //dp[0][0] = 1;
        //2.iteration over both rows and columns of the tale(grid)
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //get the code
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    //continue;
                }else{
                    int up = 0;
                    int left = 0;
                    if(i>0){
                        up = dp[i-1][j];
                    } if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        // Call the countWays function and print the result
        System.out.println(uniquePaths(m, n));

    }
}
