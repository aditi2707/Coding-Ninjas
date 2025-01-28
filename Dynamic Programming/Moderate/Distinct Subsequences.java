import java.util.*;

public class Solution {

    static int MOD = 1000000007;

    private static int distinctSubseq(String str, String sub, int m, int n, int[][] dp){

        if(n < 0){
            return 1;
        }
        if(m < 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int notPick = distinctSubseq(str, sub, m - 1, n, dp) % MOD;
        int pick = 0;

        if(str.charAt(m) == sub.charAt(n)){
            pick = distinctSubseq(str, sub, m - 1, n - 1, dp) % MOD;
        }

        return dp[m][n] = pick + notPick;
    }


    public static int distinctSubsequences(String str, String sub) {
        // Write your code here.

        int[] prev = new int[sub.length() + 1];

        prev[0] = 1;

        for(int i = 1; i <= str.length(); i++){
            int[] curr = new int[sub.length() + 1];
            curr[0] = 1;
            for(int j = 1; j <= sub.length(); j++){

                int notPick = prev[j] % MOD;
                int pick = 0;

                if(str.charAt(i - 1) == sub.charAt(j - 1)){
                    pick = prev[j - 1] % MOD;
                }

                curr[j] = pick + notPick;
            }
            prev = curr;
        }

        return prev[sub.length()];





        // int[][] dp = new int[str.length() + 1][sub.length() + 1];

        // for(int i = 0; i < str.length(); i++){
        //     dp[i][0] = 1;
        // }

        // for(int i = 1; i <= str.length(); i++){
        //     for(int j = 1; j <= sub.length(); j++){

        //         int notPick = dp[i - 1][j] % MOD;
        //         int pick = 0;

        //         if(str.charAt(i - 1) == sub.charAt(j - 1)){
        //             pick = dp[i - 1][j - 1] % MOD;
        //         }

        //         dp[i][j] = pick + notPick;
        //     }
        // }

        // return dp[str.length()][sub.length()];





        // int[][] dp = new int[str.length()][sub.length()];

        // for(int i = 0; i < str.length(); i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return distinctSubseq(str, sub, str.length() - 1, sub.length() - 1, dp);
    }
}
