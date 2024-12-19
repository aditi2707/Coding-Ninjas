import java.util.* ;
import java.io.*; 
public class Solution {

	public static int countSubsets(int[] arr, int i, int target, int[][] dp){

		if(i == 0){
			if(arr[0] == 0 && target == 0){
				return 2;
			}
			if(arr[0] == target || target == 0){
				return 1;
			}
			return 0;
		}

		if(dp[i][target] != -1){
			return dp[i][target];
		}

		if(target >= arr[i]){
			dp[i][target] = (countSubsets(arr, i - 1, target - arr[i], dp) + countSubsets(arr, i - 1, target, dp)) % 1000000007;
		}
		else{
			dp[i][target] = (countSubsets(arr, i - 1, target, dp)) % 1000000007;
		}
		
		return dp[i][target];
	}
	public static int countPartitions(int n, int d, int[] arr) {

		int sum = 0;
		for(Integer i: arr){
			sum += i;
		}

		if((sum - d) < 0 || (sum - d) % 2 != 0){
			return 0;
		}

		int totalSum = (sum - d) / 2;
		int[] prev = new int[totalSum + 1];

		if(arr[0] == 0){
			prev[0] = 2;
		}
		else{
			prev[0] = 1;
		}

		if(arr[0] != 0 && arr[0] <= totalSum){
			prev[arr[0]] = 1;
		}
		
		for(int i = 1; i < arr.length; i++){
			int[] curr = new int[totalSum + 1];
            for(int j = 0; j <= totalSum; j++){
                if(j >= arr[i]){
                    curr[j] = (prev[j - arr[i]] + prev[j]) % 1000000007;
                }
                else{
                    curr[j] = prev[j] % 1000000007;
                }
            }
			prev = curr;
        }

        
        return prev[totalSum];







		
		// int sum = 0;
		// for(Integer i: arr){
		// 	sum += i;
		// }

		// if((sum - d) < 0 || (sum - d) % 2 != 0){
		// 	return 0;
		// }

		// int totalSum = (sum - d) / 2;
		// int[][] dp = new int[arr.length][totalSum + 1];

		// if(arr[0] == 0){
		// 	dp[0][0] = 2;
		// }
		// else{
		// 	dp[0][0] = 1;
		// }

		// if(arr[0] != 0 && arr[0] <= totalSum){
		// 	dp[0][arr[0]] = 1;
		// }
		
		// for(int i = 1; i < arr.length; i++){
        //     for(int j = 0; j <= totalSum; j++){
        //         if(j >= arr[i]){
        //             dp[i][j] = (dp[i - 1][j - arr[i]] + dp[i - 1][j]) % 1000000007;
        //         }
        //         else{
        //             dp[i][j] = dp[i - 1][j] % 1000000007;
        //         }
        //     }
        // }

        
        // return dp[arr.length - 1][totalSum];








		// int sum = 0;
		// for(Integer i: arr){
		// 	sum += i;
		// }

		// if((sum - d) < 0 || (sum - d) % 2 != 0){
		// 	return 0;
		// }

		// int totalSum = (sum - d) / 2;
		// int[][] dp = new int[arr.length][totalSum + 1];
		
		// for(int i = 0; i < arr.length; i++){
		// 	Arrays.fill(dp[i], -1);
		// }

		// return countSubsets(arr, n - 1, totalSum, dp);
	}
}
