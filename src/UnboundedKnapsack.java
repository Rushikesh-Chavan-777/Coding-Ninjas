import java.util.*;

public class UnboundedKnapsack {



    public static int recurseUnboundedKnapsack(int i, int w, int[] profit, int[] weight, int[][] dp){
        //writing the base case first
        if(i == 0) {
            return ((int)w/weight[0]) * profit[0];
        }
        //writing the memoization case
        if(dp[i][w] != -1) return dp[i][w];
        //writing the general case
        int not_taken = recurseUnboundedKnapsack(i-1, w, profit, weight, dp);
        int taken = Integer.MIN_VALUE;
        if(weight[i] <= w) {
            taken = profit[i] + recurseUnboundedKnapsack(i, w - weight[i], profit, weight, dp);

        }
        return dp[i][w] = Math.max(not_taken, taken);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        //creating the dp array for memoization
        int[][] dp = new int[n][w+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return recurseUnboundedKnapsack(n-1, w, profit, weight, dp);
    }
    public static void main(String[] args) {

    }
}
