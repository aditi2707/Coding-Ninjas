import java.util.*;

public class Solution {

    private static int lcs(String s, String t, int m, int n, int[][] dp){

		if(m < 0 || n < 0){
			return 0;
		}

		if(dp[m][n] != -1){
			return dp[m][n];
		}

		if(s.charAt(m) == t.charAt(n)){
			dp[m][n] = 1 + lcs(s, t, m - 1, n - 1, dp);
		}
		else{
			dp[m][n] = Math.max(lcs(s, t, m, n - 1, dp), lcs(s, t, m - 1, n, dp));
		}

		return dp[m][n];
	}


    public static int canYouMake(String s1, String s2) {
        // Write your code here.

		int[] prev = new int[s2.length() + 1];

		for(int i = 1; i <= s1.length(); i++){
			int[] curr = new int[s2.length() + 1];
			for(int j = 1; j <= s2.length(); j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1)){
					curr[j] = 1 + prev[j - 1];
				}
				else{
					curr[j] = Math.max(curr[j - 1], prev[j]);
				}
			}
			prev = curr;
		}

		return s1.length() + s2.length() - (2 * prev[s2.length()]);




		// int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		// for(int i = 1; i <= s1.length(); i++){
		// 	for(int j = 1; j <= s2.length(); j++){
		// 		if(s1.charAt(i - 1) == s2.charAt(j - 1)){
		// 			dp[i][j] = 1 + dp[i - 1][j - 1];
		// 		}
		// 		else{
		// 			dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
		// 		}
		// 	}
		// }

		// return s1.length() + s2.length() - (2 * dp[s1.length()][s2.length()]);




		// int[][] dp = new int[s1.length()][s2.length()];

		// for(int i = 0; i < s1.length(); i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return s1.length() + s2.length() - (2 * lcs(s1, s2, s1.length() - 1, s2.length() - 1, dp));
    }
}
