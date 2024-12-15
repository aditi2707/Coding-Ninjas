import java.util.* ;
import java.io.*; 
public class Solution {

    public static int minEnergy(int n, int[] heights, int[] dp){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.abs(heights[1] - heights[0]);
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int one = Math.abs(heights[n] - heights[n - 1]) + minEnergy(n - 1, heights, dp);
        int two =  Math.abs(heights[n] - heights[n - 2]) + minEnergy(n - 2, heights, dp);

        dp[n] = Math.min(one, two);
        return dp[n];
    }

    public static int frogJump(int n, int heights[]) {

        if(n == 1){
            return 0;
        }
        if(n == 2){
            return Math.abs(heights[1] - heights[0]);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.min(Math.abs(heights[i] - heights[i - 1]) + dp[i - 1], Math.abs(heights[i] - heights[i - 2]) + dp[i - 2]);
        }

        return dp[n - 1];





        // return minEnergy(n - 1, heights, dp);
    }

}
