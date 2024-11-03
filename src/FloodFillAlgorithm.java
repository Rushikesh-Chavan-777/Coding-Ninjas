import java.util.*;

public class FloodFillAlgorithm {

    public static void dfs(int ro, int co, int iniColor, int[][] ans, int[][] image, int[] delRow, int[] delCol, int newColor) {
        //now, we shall first change the color of the present on that we shave gotten
        ans[ro][co] = newColor;
        //getting boundary conditions for the validity check in  the if loop
        int m = ans.length;
        int n = ans[0].length;

        //now, getting into the for loop
        for(int i = 0; i < 4; i++) {
            int newRow = ro + delRow[i];
            int newCol = co + delCol[i];
            if(newRow >=0 && newRow < m && newCol >= 0 && newCol < n &&
                    image[newRow][newCol] == iniColor && ans[newRow][newCol] != newColor ) {
                dfs(newRow, newCol, iniColor, ans, image, delRow, delCol, newColor);
            }
        }
    }



    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // what we shall do is perform a simple dfs algorithm and fill all the required matrix paces with the new color
        //firstly getting the initial Color
        int intiColor = image[sr][sc];
        //creating the new matrix where we shall have the updated colors
        int[][] ans = image;
        //now, creating the coordinated on which we shall traverse
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        //now passing the dfs function and filling the ans matrix and getting it done
        dfs(sr, sc, intiColor, ans, image, delRow, delCol, newColor);


        return ans;
    }

    public static void main(String[] args) {}
}
