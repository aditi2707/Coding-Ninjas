import java.util.*;
public class Solution {

    private static int lps(String s, String t, int m, int n, int[][] dp){

		if(m < 0 || n < 0){
			return 0;
		}

		if(dp[m][n] != -1){
			return dp[m][n];
		}

		if(s.charAt(m) == t.charAt(n)){
			dp[m][n] = 1 + lps(s, t, m - 1, n - 1, dp);
		}
		else{
			dp[m][n] = Math.max(lps(s, t, m, n - 1, dp), lps(s, t, m - 1, n, dp));
		}

		return dp[m][n];
	}


    public static int minInsertion(String str) {
        // Write your code here.

        String rev = "";
        String s = str;

		for(int i = 0; i < s.length(); i++){
			rev = s.charAt(i) + rev;
		}

		int[] prev = new int[s.length() + 1];

		for(int i = 1; i <= s.length(); i++){
			int[] curr = new int[s.length() + 1];
			for(int j = 1; j <= s.length(); j++){
				if(s.charAt(i - 1) == rev.charAt(j - 1)){
					curr[j] = 1 + prev[j - 1];
				}
				else{
					curr[j] = Math.max(curr[j - 1], prev[j]);
				}
			}
			prev = curr;
		}

		return s.length() - prev[s.length()];





		// String rev = "";
        // String s = str;

		// for(int i = 0; i < s.length(); i++){
		// 	rev = s.charAt(i) + rev;
		// }

		// int[][] dp = new int[s.length() + 1][s.length() + 1];

		// for(int i = 1; i <= s.length(); i++){
		// 	for(int j = 1; j <= s.length(); j++){
		// 		if(s.charAt(i - 1) == rev.charAt(j - 1)){
		// 			dp[i][j] = 1 + dp[i - 1][j - 1];
		// 		}
		// 		else{
		// 			dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
		// 		}
		// 	}
		// }

		// return s.length() - dp[s.length()][s.length()];




		// String rev = "";
        // String s = str;

		// for(int i = 0; i < s.length(); i++){
		// 	rev = s.charAt(i) + rev;
		// }

		// int[][] dp = new int[s.length()][s.length()];

		// for(int i = 0; i < s.length(); i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return s.length() - lps(s, rev, s.length() - 1, s.length() - 1, dp);
    }
}
