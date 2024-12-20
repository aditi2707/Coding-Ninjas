import java.util.*;
public class Solution {

	public static long coinChange(int[] arr, int i, int target, long[][] dp){

		if(target == 0){
			return 1;
		}
		if(i < 0 || target < 0){
			return 0;
		}

		if(dp[i][target] != -1){
			return dp[i][target];
		}

		long notPick = coinChange(arr, i - 1, target, dp);
		long pick = 0;

		if(target >= arr[i]){
			pick = coinChange(arr, i, target - arr[i], dp);
		}

		return dp[i][target] = pick + notPick;
	}

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here

		long[] prev = new long[value + 1];

		
		for(int i = 0; i <= value; i++){
			if(i % denominations[0] == 0){
				prev[i] = 1;
			}
		}

		for(int i = 1; i < denominations.length; i++){
			long[] curr = new long[value + 1];
			for(int j = 0; j <= value; j++){
				long notPick = prev[j];
				long pick = 0;

				if(j >= denominations[i]){
					pick = curr[j - denominations[i]];
				}

				curr[j] = pick + notPick;
			}
			prev = curr;
		}

		return prev[value];








		// long[][] dp = new long[denominations.length][value + 1];

		
		// for(int i = 0; i <= value; i++){
		// 	if(i % denominations[0] == 0){
		// 		dp[0][i] = 1;
		// 	}
		// }

		// for(int i = 1; i < denominations.length; i++){
		// 	for(int j = 0; j <= value; j++){
		// 		long notPick = dp[i - 1][j];
		// 		long pick = 0;

		// 		if(j >= denominations[i]){
		// 			pick = dp[i][j - denominations[i]];
		// 		}

		// 		dp[i][j] = pick + notPick;
		// 	}
		// }

		// return dp[denominations.length - 1][value];







		// long[][] dp = new long[denominations.length][value + 1];

		// for(int i = 0; i < denominations.length; i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return coinChange(denominations, denominations.length - 1, value, dp);
	}
	
}
