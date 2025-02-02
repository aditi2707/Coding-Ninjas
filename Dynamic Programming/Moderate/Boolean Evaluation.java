import java.util.*;
public class Solution {

    private static int booleanEval(char[] boo, int i, int j, int isTrue, int[][][] dp){

        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue == 1){
                return boo[i] == 'T'? 1 : 0;
            }
            else{
                return boo[i] == 'F'? 1 : 0;
            }
        }

        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for(int k = i + 1; k <= j - 1; k += 2){
            long leftTrue = booleanEval(boo, i, k - 1, 1, dp);
            long leftFalse = booleanEval(boo, i, k - 1, 0, dp);
            long rightTrue = booleanEval(boo, k + 1, j, 1, dp);
            long rightFalse = booleanEval(boo, k + 1, j, 0, dp);

            if(boo[k] == '&'){
                if(isTrue == 1){
                    ways = (ways + (leftTrue * rightTrue)) % 1000000007;
                }
                else{
                    ways = (ways + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse)) % 1000000007;
                }
            }
            else if(boo[k] == '|'){
                if(isTrue == 1){
                    ways = (ways + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue)) % 1000000007;
                }
                else{
                    ways = (ways + (leftFalse * rightFalse)) % 1000000007;
                }
            }
            else{
                if(isTrue == 1){
                    ways = (ways + (leftTrue * rightFalse) + (leftFalse * rightTrue)) % 1000000007;
                }
                else{
                    ways = (ways + (leftFalse * rightFalse) + (leftTrue * rightTrue)) % 1000000007;
                }
            }
        }

        return dp[i][j][isTrue] = (int)ways;
    }


    public static int evaluateExp(String exp) {
        char[] boo = exp.toCharArray();
        int[][][] dp = new int[boo.length][boo.length][2];

        for(int i = 0; i < boo.length; i++){
            if(boo[i] == 'T'){
                    dp[i][i][1] = 1;
                }
                if(boo[i] == 'F'){
                    dp[i][i][0] = 1;
                }
        }

        for(int i = boo.length - 1; i >= 0; i--){
            for(int j = 0; j < boo.length; j++){
                for(int p = 0; p <= 1; p++){
                    long ways = 0;
                    for(int k = i + 1; k <= j - 1; k += 2){
                        long leftTrue = dp[i][k - 1][1];
                        long leftFalse = dp[i][k - 1][0];
                        long rightTrue = dp[k + 1][j][1];
                        long rightFalse = dp[k + 1][j][0];

                        if(boo[k] == '&'){
                            if(p == 1){
                                ways = (ways + (leftTrue * rightTrue)) % 1000000007;
                            }
                            else{
                                ways = (ways + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse)) % 1000000007;
                                }
                        }
                        else if(boo[k] == '|'){
                            if(p == 1){
                                ways = (ways + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue)) % 1000000007;
                            }
                            else{
                                ways = (ways + (leftFalse * rightFalse)) % 1000000007;
                            }
                        }
                        else{
                            if(p == 1){
                                ways = (ways + (leftTrue * rightFalse) + (leftFalse * rightTrue)) % 1000000007;
                            }
                            else{
                                ways = (ways + (leftFalse * rightFalse) + (leftTrue * rightTrue)) % 1000000007;
                            }
                        }
                        dp[i][j][p] = (int)ways;
                    }
                }
            }
        }

        return dp[0][boo.length - 1][1];





        // char[] boo = exp.toCharArray();
        // int[][][] dp = new int[boo.length][boo.length][2];

        // for(int i = 0; i < boo.length; i++){
        //     for(int j = 0; j < boo.length; j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        // return booleanEval(boo, 0, boo.length - 1, 1, dp);
    }
}
