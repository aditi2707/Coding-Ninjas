import java.util.* ;
import java.io.*; 

public class Solution{
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight, int[][] dp){
        if(maxWeight == 0){
            return 0;
        }
        if(n < 0){
            return 0;
        }

        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }

        if(maxWeight >= weight[n]){
            dp[n][maxWeight] = Math.max(value[n] + knapsack(weight, value, n - 1, maxWeight - weight[n], dp), 
            knapsack(weight, value, n - 1, maxWeight, dp));
        }
        else{
            dp[n][maxWeight] = knapsack(weight, value, n - 1, maxWeight, dp);
        }

        return dp[n][maxWeight];
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */


        int[] prev = new int[maxWeight + 1];

        for(int i = 1; i <= n; i++){
            int[] curr = new int[maxWeight + 1];
            for(int j = 0; j <= maxWeight; j++){
                if(j >= weight[i - 1]){
                    curr[j] = Math.max(value[i - 1] + prev[j - weight[i - 1]], prev[j]);
                }
                else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[maxWeight];








        // int[][] dp = new int[n + 1][maxWeight + 1];


        // for(int i = 1; i <= n; i++){
        //     for(int j = 0; j <= maxWeight; j++){
        //         if(j >= weight[i - 1]){
        //             dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
        //         }
        //         else{
        //             dp[i][j] = dp[i - 1][j];
        //         }
        //     }
        // }

        // return dp[n][maxWeight];






        
        // int[][] dp = new int[n][maxWeight + 1];

        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return knapsack(weight, value, n - 1, maxWeight, dp);
    }
}
