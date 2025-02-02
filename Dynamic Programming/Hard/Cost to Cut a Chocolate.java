import java.util.*;
import java.io.*; 
public class Solution {

    private static int minCostToCutChoco(int[] arr, int i, int j, int[][] dp){

        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = 1000000000;
        for(int k = i; k <= j; k++){
            int cost = arr[j + 1] - arr[i - 1] + minCostToCutChoco(arr, i, k - 1, dp) + 
                        minCostToCutChoco(arr, k + 1, j, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }


    public static int cost(int n, int c, int cuts[]) {

        // Write your code here..

        Arrays.sort(cuts);
        int[] arr = new int[c + 2];
        for(int i = 1; i < arr.length - 1; i++){
            arr[i] = cuts[i - 1];
        }
        
        arr[0] = 0;
        arr[arr.length - 1] = n;

        int[][] dp = new int[c + 2][c + 2];

        for(int i = c; i >= 1; i--){
            for(int j = 1; j <= c; j++){
                if(i > j){
                    continue;
                }
                int min = 1000000000;
                for(int k = i; k <= j; k++){
                    int cost = arr[j + 1] - arr[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][c];




        // Arrays.sort(cuts);
        // int[] arr = new int[c + 2];
        // for(int i = 1; i < arr.length - 1; i++){
        //     arr[i] = cuts[i - 1];
        // }
        
        // arr[0] = 0;
        // arr[arr.length - 1] = n;

        // int[][] dp = new int[c + 2][c + 2];

        // for(int i = 0; i < c + 2; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return minCostToCutChoco(arr, 1, arr.length - 2, dp);
    }

}
