import java.util.Arrays;

public class NinjasTraining {


    public static int f(int day, int last, int[][] dp, int[][] points){
        //memoization condition using the DP Array
        if(dp[day][last] != -1) {
            return dp[day][last];
        }
        //considering the base case, where we shall return and stop to recurse further
        if(day == 0) {
            int maxi = 0;
            for(int i = 0; i <= 2; i ++) {
                if(i != last) {
                    maxi = Math.max(maxi, points[day][i]);
                }

            }
            return maxi;
        }
        //going for all the other non-base cases
        int maxi = 0;
        for(int i = 0; i <=2; i++) {
            if(i != last) {
                int activity = points[day][i] + f(day-1, i, dp, points);
                maxi = Math.max(maxi, activity);
            }
        }
        dp[day][last] = maxi;
        return dp[day][last];
    }
    public static int ninjaTraining(int n, int [][] points) {
        int[][] dp = new int[n][4];
        for(int[] row : dp) {
         Arrays.fill(row, -1);
        }
        return f(n-1, 3, dp, points);
    }


    public static void main(String[] args) {

        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points));

    }
}
