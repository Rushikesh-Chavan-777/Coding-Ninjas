import java.util.*;

public class DistinctSubsequences {


    public static int recurseDistinctSubsequences(int i, int j, String a, String b, int[][] dp) {
        // writing the base cases first
        if(j < 0) return 1;
        if(i < 0) return 0;
        //the memoization case
        if(dp[i][j] != -1) return dp[i][j];
        //the general cases
        //suing the matching and not_matching approach that is very common is String DP Problems
        if(a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = (recurseDistinctSubsequences(i-1, j-1, a, b, dp)+ recurseDistinctSubsequences(i-1, j, a , b, dp)) % (int)(Math.pow(10,9)+7);
        }else {
            return dp[i][j] = recurseDistinctSubsequences(i-1, j, a, b, dp);
        }
    }


    public static int distinctSubsequences(String str, String sub) {
        // creating the dp array of the indexes so as to memoize
        int[][] dp = new int[str.length()][sub.length()];
        for(int[] row: dp) Arrays.fill(row, -1);
        return recurseDistinctSubsequences(str.length()-1, sub.length()-1, str, sub, dp);
    }


    public static void main(String[] args) {}
}
