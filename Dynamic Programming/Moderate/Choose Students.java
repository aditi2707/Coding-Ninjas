import java.util.* ;
import java.io.*; 
public class Solution {

	private static int chooseStudents(int n, int r, int[][] dp){

		if(r == 0){
			return 1;
		}
		if(n == 0){
			return 0;
		}

		if(dp[n][r] != -1){
			return dp[n][r];
		}

		int pick = chooseStudents(n - 1, r - 1, dp);
		int notPick = chooseStudents(n - 1, r, dp);

		return dp[n][r] = pick + notPick;
	}


	public static int choose(int n, int r) {
		// Write your code here.

		int[] prev = new int[r + 1];

		prev[0] = 1;

		for(int i = 1; i <= n; i++){
			int[] curr = new int[r + 1];
			curr[0] = 1;
			for(int j = 1; j <= r; j++){
				int pick = prev[j - 1];
				int notPick = prev[j];

				curr[j] = pick + notPick;
			}
			prev = curr;
		}

		return prev[r];






		// int[][] dp = new int[n + 1][r + 1];

		// for(int i = 0; i <= n; i++){
		// 	dp[i][0] = 1;
		// }

		// for(int i = 1; i <= n; i++){
		// 	for(int j = 1; j <= r; j++){
		// 		int pick = dp[i - 1][j - 1];
		// 		int notPick = dp[i - 1][j];

		// 		dp[i][j] = pick + notPick;
		// 	}
		// }

		// return dp[n][r];





		// int[][] dp = new int[n + 1][r + 1];

		// for(int i = 0; i <= n; i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return chooseStudents(n, r, dp);
	}
}
