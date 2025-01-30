import java.util.*;
public class Solution {

    private static int editDistance(String s, String t, int m, int n, int[][] dp){

        if(m < 0){
            return n + 1;
        }
        if(n < 0){
            return m + 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s.charAt(m) == t.charAt(n)){
            dp[m][n] = editDistance(s, t, m - 1, n - 1, dp);
        }
        else{
            int insert = 1 + editDistance(s, t, m, n - 1, dp);
            int replace = 1 + editDistance(s, t, m - 1, n - 1, dp);
            int delete = 1 + editDistance(s, t, m - 1, n, dp);

            dp[m][n] = Math.min(insert, Math.min(replace, delete));
        }

        return dp[m][n];
    }

    public static int editDistance(String str1, String str2) {
        //Your code goes here

        int[] prev = new int[str2.length() + 1];

        for(int i = 1; i <= str2.length(); i++){
            prev[i] = i;
        }

        for(int i = 1; i <= str1.length(); i++){
            int[] curr = new int[str2.length() + 1];
            curr[0] = i;
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    curr[j] = prev[j - 1];
                }
                else{
                    int insert = 1 + curr[j - 1];
                    int replace = 1 + prev[j - 1];
                    int delete = 1 + prev[j];

                    curr[j] = Math.min(insert, Math.min(replace, delete));
                }
            }
            prev = curr;
        }

        return prev[str2.length()];





        // int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // for(int i = 1; i <= str2.length(); i++){
        //     dp[0][i] = i;
        // }
        // for(int i = 1; i <= str1.length(); i++){
        //     dp[i][0] = i;
        // }

        // for(int i = 1; i <= str1.length(); i++){
        //     for(int j = 1; j <= str2.length(); j++){
        //         if(str1.charAt(i - 1) == str2.charAt(j - 1)){
        //             dp[i][j] = dp[i - 1][j - 1];
        //         }
        //         else{
        //             int insert = 1 + dp[i][j - 1];
        //             int replace = 1 + dp[i - 1][j - 1];
        //             int delete = 1 + dp[i - 1][j];

        //             dp[i][j] = Math.min(insert, Math.min(replace, delete));
        //         }
        //     }
        // }

        // return dp[str1.length()][str2.length()];





        // int[][] dp = new int[str1.length()][str2.length()];

        // for(int i = 0; i < str1.length(); i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return editDistance(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }
}
