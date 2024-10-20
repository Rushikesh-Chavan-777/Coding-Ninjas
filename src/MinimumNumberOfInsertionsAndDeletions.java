import java.util.*;

public class MinimumNumberOfInsertionsAndDeletions {


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

    public static int canYouMake(String s1, String s2) {
        // We shall apply a simple technuque, where
        //we first find the lcs, of both and keep them the way they are
        //from first string, remaining characters, will be the ones ot be deleted
        //the remaining characters fron the second string will be the ones to be inserted in the first
        int lcs_character_count = tabulateLCS(s1, s2);
        int deletions = s1.length() - lcs_character_count;
        int insertions = s2.length() - lcs_character_count;
        return deletions + insertions;
    }

    public static void main(String[] args) {}
}
