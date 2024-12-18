import java.util.*;
import java.io.*;

public class Solution {

    public static int countSubsets(int[] num, int i, int target, int[][] dp){

        if(target == 0){
            return 1;
        }
        if(i == 0){
            return num[i] == target? 1 : 0;
        }

        if(dp[i][target] != -1){
            return dp[i][target];
        }

        if(target >= num[i]){
            dp[i][target] = (countSubsets(num, i - 1, target - num[i], dp) + countSubsets(num, i - 1, target, dp)) % (1000000000 + 7);
        }
        else{
            dp[i][target] = (countSubsets(num, i - 1, target, dp)) % (1000000000 + 7);
        }

        return dp[i][target]; 
    }
    public static int findWays(int num[], int tar) {
        // Write your code here.

        int[] prev = new int[tar + 1];

        Arrays.sort(num);
        for(int i = 0; i <= num.length / 2; i++){
            int temp = num[i];
            num[i] = num[num.length - 1 - i];
            num[num.length - 1 - i] = temp;
        }
        
        for(int i = 0; i <= num.length; i++){
            prev[0] = 1;
        }

        for(int i = 1; i <= num.length; i++){
            int[] curr = new int[tar + 1];
            for(int j = 0; j <= tar; j++){
                if(j >= num[i - 1]){
                    curr[j] = (prev[j - num[i - 1]] + prev[j]) % 1000000007;
                }
                else{
                    curr[j] = prev[j] % 1000000007;
                }
            }
            prev = curr;
        }

        
        return prev[tar];







        // int[][] dp = new int[num.length + 1][tar + 1];

        // Arrays.sort(num);
        // for(int i = 0; i <= num.length / 2; i++){
        //     int temp = num[i];
        //     num[i] = num[num.length - 1 - i];
        //     num[num.length - 1 - i] = temp;
        // }
        
        // for(int i = 0; i <= num.length; i++){
        //     dp[i][0] = 1;
        // }
        // if(num[0] <= tar){
        //     dp[0][0] = 1;
        // }

        // for(int i = 1; i <= num.length; i++){
        //     for(int j = 0; j <= tar; j++){
        //         if(j >= num[i - 1]){
        //             dp[i][j] = (dp[i - 1][j - num[i - 1]] + dp[i - 1][j]) % 1000000007;
        //         }
        //         else{
        //             dp[i][j] = dp[i - 1][j] % 1000000007;
        //         }
        //     }
        // }

        
        // return dp[num.length][tar];







        // int[][] dp = new int[num.length + 1][tar + 1];
        
        // for(int i = 0; i <= num.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // Arrays.sort(num);
        // for(int i = 0; i <= num.length / 2; i++){
        //     int temp = num[i];
        //     num[i] = num[num.length - 1 - i];
        //     num[num.length - 1 - i] = temp;
        // }
        // return countSubsets(num, num.length - 1, tar, dp);
    }
}
