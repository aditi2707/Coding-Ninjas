import java.util.* ;
import java.io.*; 

public class Solution {

	private static int mcm(int[] arr, int i, int j, int[][] dp){

		if(i == j){
			return 0;
		}

		if(dp[i][j] != -1){
			return dp[i][j];
		}

		int min = 1000000000;
		for(int k = i; k < j; k++){
			int steps = (arr[i - 1] * arr[k] * arr[j]) + mcm(arr, i, k, dp) + mcm(arr, k + 1, j, dp);
			min = Math.min(min, steps);
		}

		return dp[i][j] = min;
	}


	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here

		int[][] dp = new int[N][N];

		for(int i = 0; i < N; i++){
			dp[i][i] = 0;
		}

		for(int i = N - 1; i >= 1; i--){
			for(int j = i + 1; j < N; j++){
				int min = 1000000000;
				for(int k = i; k < j; k++){
					int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
					min = Math.min(min, steps);
				}

				dp[i][j] = min;
			}
		}

		return dp[1][N - 1];




		// int[][] dp = new int[N][N];

		// for(int i = 0; i < N; i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return mcm(arr, 1, N - 1, dp);
	}
}
