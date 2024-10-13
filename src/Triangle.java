import java.util.*;

public class Triangle {

    // Function to find the minimum path sum in the triangle using dynamic programming
    static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
        // Check if the result for the current position (i, j) is already calculated
        if (dp[i][j] != -1)
            return dp[i][j];

        // If we are at the bottom row, return the value in the triangle
        if (i == n - 1)
            return triangle[i][j];

        // Calculate the minimum path sum by recursively considering two possible paths: down and diagonal
        int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

        // Store the result in the dp array and return the minimum of the two paths
        return dp[i][j] = Math.min(down, diagonal);
    }

    // Function to find the minimum path sum in the triangle
    static int minimumPathSum(int[][] triangle, int n) {
        // Create a 2D array to store computed results, initialize with -1
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the utility function to find the minimum path sum starting from the top
        return minimumPathSumUtil(0, 0, triangle, n, dp);
    }
}
