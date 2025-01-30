import java.util.*;

public class Solution {

	private static boolean patternMatching(String pattern, String text, int m, int n, int[][] dp){

		if(n < 0 && m < 0){
			return true;
		}
		if(m < 0){
			return false;
		}
		if(n < 0){
			for(int i = m; i >= 0; i--){
				if(pattern.charAt(i) != '*'){
					return false;
				}
			}
			return true;
		}

		if(dp[m][n] != -1){
			return dp[m][n] == 1;
		}

		boolean res = false;

		if(pattern.charAt(m) == text.charAt(n) || pattern.charAt(m) == '?'){
			res = patternMatching(pattern, text, m - 1, n - 1, dp);
		}
		else{
			if(pattern.charAt(m) == '*'){
				res = patternMatching(pattern, text, m, n - 1, dp) || patternMatching(pattern, text, m - 1, n, dp);
			}
		}

		if(res){
			dp[m][n] = 1;
		}
		else{
			dp[m][n] = 0;
		}

		return res;
	}


	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.

		boolean[] prev = new boolean[text.length() + 1];

		prev[0] = true;

		for(int i = 1; i <= pattern.length(); i++){
			boolean[] curr = new boolean[text.length() + 1];

			for(int j = 1; j <= pattern.length(); j++){
				if(pattern.charAt(j - 1) == '*'){
					curr[0] = true;
				}
				else{
					break;
				}
			}
			
			for(int j = 1; j <= text.length(); j++){
				boolean res = false;

				if(pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?'){
					res = prev[j - 1];
				}
				else{
					if(pattern.charAt(i - 1) == '*'){
						res = curr[j - 1] || prev[j];
					}
				}
				curr[j] = res;
			}
			prev = curr;
		}

		return prev[text.length()];





		// boolean[][] dp = new boolean[pattern.length() + 1][text.length() + 1];

		// dp[0][0] = true;

		// for(int i = 1; i <= text.length(); i++){
		// 	dp[0][i] = false;
		// }

		// for(int i = 1; i <= pattern.length(); i++){
		// 	if(pattern.charAt(i - 1) == '*'){
		// 		dp[i][0] = true;
		// 	}
		// 	else{
		// 		break;
		// 	}
		// }

		// for(int i = 1; i <= pattern.length(); i++){
		// 	for(int j = 1; j <= text.length(); j++){
		// 		boolean res = false;

		// 		if(pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?'){
		// 			res = dp[i - 1][j - 1];
		// 		}
		// 		else{
		// 			if(pattern.charAt(i - 1) == '*'){
		// 				res = dp[i][j - 1] || dp[i - 1][j];
		// 			}
		// 		}
		// 		dp[i][j] = res;
		// 	}
		// }

		// return dp[pattern.length()][text.length()];





		// int[][] dp = new int[pattern.length()][text.length()];

		// for(int i = 0; i < pattern.length(); i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return patternMatching(pattern, text, pattern.length() - 1, text.length() - 1, dp);
	}
}
