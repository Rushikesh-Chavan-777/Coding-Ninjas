import java.util.*;

public class BestTimeToBuyAndSellStock2 {


    //we shall use the same code as we did in problem three, but we shall take a value k dynamically to change whenever needed instead of 2 only.
    public static int recurseMaxProfit(int i, int buy, int cap, int n, int[] prices, int[][][] dp) {
        //writing the base cases
        if (i == n) return 0;
        if (cap == 0) return 0;
        //writing the memoization case
        if (dp[i][buy][cap] != -1) return dp[i][buy][cap];
        //creating the profit variable
        int profit = 0;
        //writing the general case
        if (buy == 0) {
            profit = Math.max(recurseMaxProfit(i + 1, 0, cap, n, prices, dp), -prices[i] + recurseMaxProfit(i + 1, 1, cap, n, prices, dp));
        } else {
            profit = Math.max(recurseMaxProfit(i + 1, 1, cap, n, prices, dp), prices[i] + recurseMaxProfit(i + 1, 0, cap - 1, n, prices, dp));

        }
        return dp[i][buy][cap] = profit;
    }

    public static int maximumProfit(int[] prices, int n, int k) {
        //creating a dp array for memoization
        int[][][] dp = new int[prices.length][2][k+1];
        for(int[][] row: dp) {
            for(int[] rows: row) {
                Arrays.fill(rows, -1);
            }
        }
        return recurseMaxProfit(0, 0, k, n, prices, dp);
    }


    public static void main(String[] args) {}
}
