import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths2 {

    public static int recurseUniquePaths2(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] dp){
        //making the blocked path as an edge case
        if(i >= 0 && j>= 0 && mat.get(i).get(j) == -1) {
            return 0;
        }
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
        int up = recurseUniquePaths2(i-1, j,mat, dp);
        int left = recurseUniquePaths2(i, j-1, mat, dp);
        return dp[i][j] = up + left;
    }
    public static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[m][n];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return recurseUniquePaths2(m-1, n-1, mat, dp);
    }


    public static void main(String[] args) {



    }




}
