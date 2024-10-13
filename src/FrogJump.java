import java.util.*;

public class FrogJump {

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return frogJump_Recursive(n-1, heights, dp);

    }

    //using recursion and memoization
    public static int frogJump_Recursive(int n, int[] heights, int[] dp) {

        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int val_right = Integer.MAX_VALUE;
        int val_left = frogJump_Recursive(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);

        if(n>1)  val_right = frogJump_Recursive(n-2, heights, dp) + Math.abs(heights[n] - heights[n-1]);

        dp[n] = Math.min(val_left, val_right);
        return dp[n];
    }


    public static int recurse2(int n, int[] heights, int[] dp) {

        //making the base case
        if(n == 0) {
            return 0;
        }
        //memoization case
        if(dp[n] != -1) {
            return dp[n];
        }
        //general recursion case
        int two = Integer.MAX_VALUE;
        int one = Math.abs(heights[n] - heights[n-1]) + recurse2(n-1, heights, dp);
        if(n>1) {
            two = Math.abs(heights[n] - heights[n - 2]) + recurse2(n - 1, heights, dp);
        }
        dp[n] = Math.min(one, two);

        return dp[n];
    }

    //method to tabulate this one dimensional dp problem
    static int tabulateRecursion2(int n, int[] heights, int[] dp) {
        //steps
        //create the base case
        //iterate all possibilities from there
        //copy & paste code in step 2

        //base case
        dp[0] = 0;
        //iterating all possibilities
        for(int i = 1; i <=n; i++) {
            //going with the above code on recursion in a tabulated approach using the dp array
            int two = Integer.MAX_VALUE;
            int one = Math.abs(heights[i] - heights[i-1]) + dp[i-1];
            if(i>1) {
                two = Math.abs(heights[i] - heights[i-2]) + dp[n - 1];
            }
            dp[n] = Math.min(one, two);

        }
        return dp[n];
    }





    public static void main(String[] args) {

    }
}
