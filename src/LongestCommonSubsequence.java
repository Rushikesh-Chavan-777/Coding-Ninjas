import java.util.*;

public class LongestCommonSubsequence {
    //using the recursive approach
    public static int recurseLCS(int i, int j, String s, String t, int[][] dp) {
        //writing the base case when we go back up the recursion tree
        if(i <0 | j < 0) {
            return 0;
        }
        //writing the memoization case
        if(dp[i][j] != -1) return dp[i][j];
        //writing the general case
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + recurseLCS(i-1, j-1, s, t, dp);
        }
        else {
            return dp[i][j] = Math.max(recurseLCS(i-1, j, s, t, dp), recurseLCS(i, j-1, s, t, dp));
        }
    }
    public static int lcs(String s, String t) {
        //making the dp array for memoization
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp) Arrays.fill(row, -1);
        return recurseLCS(s.length()-1, t.length()-1, s, t, dp);
    }
    //using the tabulation approach
    public static int tabulateLCS(String s, String t) {
        int n = s.length();
        int m = t.length();
        //creating the dp array with a little shift in indexing
        int[][] dp = new int[n+1][m+1];
        //filling the dp array
        for(int[] row: dp) Arrays.fill(row, -1);
        //writing the base cases and then going bottom up
        for(int i = 0; i <=n; i++) {
           dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        //now, write all loops for the traversal we are doing. Nested loop
        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= m; j++) {
                //copy the code and general cases in a tabulated way. Progressing bottom to up
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
    }

    public static void main(String[] args) {

    }
}
