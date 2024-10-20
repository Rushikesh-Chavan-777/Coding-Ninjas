import java.util.*;

public class BestTimeToBuyAndSellStocksWithTransactionFee {

    public static int recurseGetMaximumProfit(int i, int buy,int fee, int n, int[] values, int[][] dp){
        //writing the base cases
        if(i == n) {
            return 0;
        }
        int profit = 0;
        // writing the memoization case
        if(dp[i][buy] != -1) return dp[i][buy];
        //writing the general case to get deeper into the recursive code
        if(buy == 0) {
            profit = Math.max(recurseGetMaximumProfit(i+1, 0,fee, n, values, dp), -values[i] + recurseGetMaximumProfit(i+1, 1,fee, n, values, dp));

        }else {
            profit = Math.max(recurseGetMaximumProfit(i+1, 1,fee, n, values, dp), values[i] - fee + recurseGetMaximumProfit(i+1, 0,fee, n , values, dp));
        }
        return dp[i][buy] = profit;
    }

    public static int maximumProfit(int[] prices, int n, int fee) {
        //creating the dp array to perform memoization
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return recurseGetMaximumProfit(0, 0, fee, n, prices, dp );
    }


    public static void main(String[] args) {}
}
