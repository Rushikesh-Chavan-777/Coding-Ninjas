import java.util.*;

public class BuyAndSellStock2 {

    public static long recurseGetMaximumProfit(int i, int buy, int n, long[] values, long[][] dp){
        //writing the base cases
        if(i == n) {
            return 0;
        }
        long profit = 0;
        // writing the memoization case
        if(dp[i][buy] != -1) return dp[i][buy];
        //writing the general case to get deeper into the recursive code
        if(buy == 0) {
            profit = Math.max(recurseGetMaximumProfit(i+1, 0, n, values, dp), -values[i] + recurseGetMaximumProfit(i+1, 1, n, values, dp));

        }else {
            profit = Math.max(recurseGetMaximumProfit(i+1, 1, n, values, dp), values[i] + recurseGetMaximumProfit(i+1, 0, n , values, dp));
        }
        return dp[i][buy] = profit;
    }


    public static long getMaximumProfit (int n, long[] values) {
        // creating a dp array to apply memoization
        long[][] dp = new long[n][2];
        for(long[] row: dp) Arrays.fill(row, -1);
        if(n == 0) {
            return 0;
        }
        return recurseGetMaximumProfit(0, 0, n, values, dp);
    }
}
