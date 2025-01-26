import java.util.* ;
import java.io.*; 
public class Solution {

    public static int minElem(int[] num, int i, int x, int[][] dp){

        if(i == 0){
            if(x % num[0] == 0){
                return x / num[0];
            }
            return 1000000000;
        }

        if(dp[i][x] != -1){
            return dp[i][x];
        }

        int pick = 1000000000;
        int notPick = minElem(num, i - 1, x, dp);

        if(x >= num[i]){
            pick = 1 + minElem(num, i, x - num[i], dp);
        }

        dp[i][x] = Math.min(pick, notPick);
        return dp[i][x];

    }

    public static int minimumElements(int num[], int x) {
        // Write your code here..

        int[] prev = new int[x + 1];

        for(int i = 0; i <= x; i++){
            if(i % num[0] == 0){
                prev[i] = i / num[0];
            }
            else{
                prev[i] = 1000000000;
            }
        }


        for(int i = 1; i < num.length; i++){
            int[] curr = new int[x + 1];
            for(int j = 0; j <= x; j++){
                int pick = 1000000000;
                int notPick = prev[j];

                if(j >= num[i]){
                    pick = 1 + curr[j - num[i]];
                }

                curr[j] = Math.min(pick, notPick);
            }
            prev = curr;
        }

        return prev[x] >= 1000000000? -1 : prev[x];









        // int[][] dp = new int[num.length][x + 1];

        // for(int i = 0; i <= x; i++){
        //     if(i % num[0] == 0){
        //         dp[0][i] = i / num[0];
        //     }
        //     else{
        //         dp[0][i] = 1000000000;
        //     }
        // }


        // for(int i = 1; i < num.length; i++){
        //     for(int j = 0; j <= x; j++){
        //         int pick = 1000000000;
        //         int notPick = dp[i - 1][j];

        //         if(j >= num[i]){
        //             pick = 1 + dp[i][j - num[i]];
        //         }

        //         dp[i][j] = Math.min(pick, notPick);
        //     }
        // }

        // return dp[num.length - 1][x] >= 1000000000? -1 : dp[num.length - 1][x];









        // int[][] dp = new int[num.length][x + 1];

        // for(int i = 0; i < num.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // int min = minElem(num, num.length - 1, x, dp);
        // return min >= 1000000000? -1 : min;
    }

}
