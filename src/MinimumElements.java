import java.util.*;

public class MinimumElements {


    //using the recursion approach
    public static int recurseMinimumElements(int i, int target, int[] num, int[][] dp) {
        //base case first
        if(i == 0) {
            if(target%num[i] == 0) {
                return target/num[i];
            }else {
                // Otherwise, it's impossible to form the target using num[0] alone
                return Integer.MAX_VALUE;
            }
        }
        //memoization case
        if(dp[i][target] != -1) {
            return dp[i][target];
        }
        //general case
        //suing the taken and not taken approach
        int not_taken = recurseMinimumElements(i-1, target, num, dp);
        int taken = Integer.MAX_VALUE;
        if(num[i] <= target) {
            //remember, whenever we have a case where we can take infinite cases from same element(i.e repetition is allowed), then we should keep it i and not i-1
            taken = 1 + recurseMinimumElements(i, target - num[i], num, dp);
        }
        return dp[i][target] = Math.min(not_taken, taken);
    }


    public static int minimumElements(int num[], int x) {
        //creating the dp array for memoization
        int[][] dp = new int[num.length][x+1];
        //filling the array with -1
        for(int[] row : dp) {
            Arrays.fill(row, -1);//doing this because fill function only works with 1D arrays
        }
        int result = recurseMinimumElements(num.length - 1, x, num, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    public static void main(String[] args) {}
}
