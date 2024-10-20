import java.util.*;

public class BestTimeToBuyAndSellStockWithCoolDown {
    //calling a recursive function just as we did ith buy and sell stocks tow, with infinite transaction limit


    public static int recurseRecurseStockProfit(int i, int buy, int n, int[] prices, int[][] dp) {
        //writing the base case
        if(i >= n) return 0;
        //writing the memoization case
        if(dp[i][buy] != -1) return dp[i][buy];
        //declaring the profit integer
        int profit = 0;
        //writing the general case
        if(buy == 0) {//we can buy
            //take and not cases, but the maximum of the two
            profit = Math.max(recurseRecurseStockProfit(i + 1, 0, n, prices, dp), -prices[i] + recurseRecurseStockProfit(i+1,1,n, prices, dp));
        }else {//we cannot buy
            profit = Math.max(recurseRecurseStockProfit(i+1, 1, n, prices, dp), prices[i] + recurseRecurseStockProfit(i+2,0,n,prices,dp));
        }
        return dp[i][buy] = profit;
    }
    public static int stockProfit(int[] prices) {
        // creating a dp array for memoization
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return recurseRecurseStockProfit(0, 0, prices.length, prices, dp);
    }


    public static void main(String[] args) {}
}
