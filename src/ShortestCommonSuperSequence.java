import java.util.*;

public class ShortestCommonSuperSequence {
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

    public static String shortestSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();
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
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        //now that we are done tabulating, let us traverse backwards and apply the required logic
        int i = n;
        int j = m;
        String ans = "";
        while(i > 0 && j > 0) {
            if(a.charAt(i-1) == b.charAt(j-1)) {
                ans += a.charAt(i - 1);
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]) {
                ans += a.charAt(i - 1);
                i--;
            }else {
                ans += b.charAt(j - 1);
                j--;
            }
        }
        while(i > 0) {
            ans += a.charAt(i - 1);
            i--;
        }
        while(j> 0) {
            ans += b.charAt(j - 1);
            j--;
        }
        String ans2 = new StringBuilder(ans).reverse().toString();
        return ans2;
    }


    public static void main(String[] args) {}
}
