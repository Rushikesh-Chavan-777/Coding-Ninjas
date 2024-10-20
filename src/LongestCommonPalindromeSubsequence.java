import java.util.*;

public class LongestCommonPalindromeSubsequence {




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


    public static int longestPalindromeSubsequence(String s) {
        //The concept we are applying here is to reverse the given string,then scheck the longest comkin subsequence in the orginal and reversed
        String s_reversed = new StringBuilder(s).reverse().toString();
        return tabulateLCS(s, s_reversed);
    }


    public static void main(String[] args) {}
}
