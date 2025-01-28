import java.util.* ;
import java.io.*; 
public class Solution {
    public static String shortestSupersequence(String a, String b) {
        // Write your code here..

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = a.length(), j = b.length();
        String ans = "";

        while(i > 0 && j > 0){
            if(a.charAt(i - 1) == b.charAt(j - 1)){
                ans = a.charAt(i - 1) + ans;
                i--;
                j--;
            }
            else{
                if(dp[i - 1][j] > dp[i][j - 1]){
                    ans = a.charAt(i - 1) + ans;
                    i--;
                }
                else{
                    ans = b.charAt(j - 1) + ans;
                    j--;
                }
            }
        }

        while(i > 0){
            ans = a.charAt(i - 1) + ans;
            i--;
        }
        while(j > 0){
            ans = b.charAt(j - 1) + ans;
            j--;
        }

        return ans;
    }

}
