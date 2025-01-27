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
			dp[m][n] = Math.max(lcs(s, t, m - 1, n, dp), lcs(s, t, m, n - 1, dp));
		}
		
		return dp[m][n];
	}

	public static int lcs(String s, String t) {
		//Your code goes here

		int[] prev = new int[t.length() + 1];

		prev[0] = 1;

		for(int i = 1; i <= s.length(); i++){
			int[] curr = new int[t.length() + 1];
			for(int j = 1; j <= t.length(); j++){
				if(s.charAt(i - 1) == t.charAt(j - 1)){
					curr[j] = 1 + prev[j - 1];
				}
				else{
					curr[j] = Math.max(prev[j], curr[j - 1]);
				}
			}
			prev = curr;
		}

		return prev[t.length()];




		// int[][] dp = new int[s.length() + 1][t.length() + 1];

		// for(int i = 1; i <= s.length(); i++){
		// 	for(int j = 1; j <= t.length(); j++){
		// 		if(s.charAt(i - 1) == t.charAt(j - 1)){
		// 			dp[i][j] = 1 + dp[i - 1][j - 1];
		// 		}
		// 		else{
		// 			dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		// 		}
		// 	}
		// }

		// return dp[s.length()][t.length()];




		// int[][] dp = new int[s.length()][t.length()];

		// for(int i = 0; i < s.length(); i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return lcs(s, t, s.length() - 1, t.length() - 1, dp);
    }

}
