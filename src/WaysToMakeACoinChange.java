import java.util.*;

public class WaysToMakeACoinChange {


    //using our recursive approach
    public static long recurseWaysToMakeChange(int i, int target, int[] denominations, long[][] dp) {
        //writing the base case
        if(i == 0) {
            if(target%denominations[i] == 0) {
                return 1;
            }else {
                return 0;
            }
        }
        //writing the memoization case
        if(dp[i][target] != -1) return dp[i][target];
        //writing the general case
        long not_taken = recurseWaysToMakeChange(i-1, target, denominations, dp);
        long taken = 0;
        if(denominations[i] <= target) {
            taken = recurseWaysToMakeChange(i, target - denominations[i], denominations, dp);
        }
        return dp[i][target] = not_taken + taken;
    }


    public static long countWaysToMakeChange(int[] denominations, int value){
        //making the dp array for memoization purpose
        long[][] dp = new long[denominations.length][value + 1];
        for(long[] row : dp) Arrays.fill(row, -1);

        return recurseWaysToMakeChange(denominations.length-1, value, denominations, dp);
    }


    public static void main(String[] args) {

    }
}
