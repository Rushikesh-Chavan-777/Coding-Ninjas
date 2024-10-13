import java.util.*;

public class Knapsack {
    public static int recurseKNapSack(int i, int w,int[] weight, int[] value, int[][] dp){
        //using our regular table/not table approach
        //writing about base case
        if(i == 0) {
            if(weight[i] <= w) {
                return value[i];
            } else{
                return 0;
            }
        }
        //writing the memoization case
        if(dp[i][w] != -1) {
            return dp[i][w];
        }
        //writing the general cases now
        //not take case
        int not_take = recurseKNapSack(i-1, w, weight, value, dp);
        //take case
        int take = Integer.MIN_VALUE;
        if(weight[i] <= w) {
            take = value[i] + recurseKNapSack(i-1, w - weight[i], weight, value, dp);
        }
        return dp[i][w] = Math.max(not_take, take);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        //creating the dp array
        int[][] dp = new int[n][maxWeight+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return recurseKNapSack(n-1, maxWeight, weight, value, dp);
    }


    public static void main(String[] args) {

        System.out.println();

    }
}
