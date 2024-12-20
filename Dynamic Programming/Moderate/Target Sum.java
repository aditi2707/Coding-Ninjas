import java.util.* ;
import java.io.*; 
public class Solution {

    public static int tarSum(int[] arr, int i, int target, int[][] dp){

        if(i == 0){
            if(target == 0 && arr[0] == 0){
                return 2;
            }
            if(target == 0 || arr[0] == target){
                return 1;
            }
            return 0;
        }

        if(dp[i][target] != -1){
            return dp[i][target];
        }

        int notPick = tarSum(arr, i - 1, target, dp);
        int pick = 0;

        if(target >= arr[i]){
            pick = tarSum(arr, i - 1, target - arr[i], dp);
        }

        dp[i][target] = pick + notPick;
        
        return dp[i][target];
    }
    
    public static int targetSum(int n, int target, int[] arr) {
    	// Write your code here.

        int sum = 0;
		for(Integer i: arr){
			sum += i;
		}

		if((sum - target) < 0 || (sum - target) % 2 != 0){
			return 0;
		}

		int total = (sum - target) / 2;
		int[] prev = new int[total + 1];

		if(arr[0] == 0){
			prev[0] = 2;
		}
		else{
			prev[0] = 1;
		}

		if(arr[0] != 0 && arr[0] <= total){
			prev[arr[0]] = 1;
		}
		
		for(int i = 1; i < arr.length; i++){
			int[] curr = new int[total + 1];
            for(int j = 0; j <= total; j++){
                if(j >= arr[i]){
                    curr[j] = (prev[j - arr[i]] + prev[j]) % 1000000007;
                }
                else{
                    curr[j] = prev[j] % 1000000007;
                }
            }
			prev = curr;
        }

        
        return prev[total];








        // int sum = 0;
        // for(Integer i: arr){
        //     sum += i;
        // }

        // if((sum - target) % 2 != 0 || (sum - target) < 0){
        //     return 0;
        // }

        // int total = (sum - target) / 2;

        // int[][] dp = new int[n][total + 1];
        
        // if(arr[0] == 0){
		// 	dp[0][0] = 2;
		// }
		// else{
		// 	dp[0][0] = 1;
		// }

		// if(arr[0] != 0 && arr[0] <= total){
		// 	dp[0][arr[0]] = 1;
		// }


        // for(int i = 1; i < n; i++){
        //     for(int j = 0; j <= total; j++){
        //         int notPick = dp[i - 1][j];
        //         int pick = 0;

        //         if(j >= arr[i]){
        //             pick = dp[i - 1][j - arr[i]];
        //         }

        //         dp[i][j] = pick + notPick;
        //     }
        // }

        // return dp[n - 1][total];










        // int sum = 0;
        // for(Integer i: arr){
        //     sum += i;
        // }

        // if((sum - target) % 2 != 0 || (sum - target) < 0){
        //     return 0;
        // }

        // int total = (sum - target) / 2;

        // int[][] dp = new int[n][total + 1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return tarSum(arr, n - 1, total, dp);







        // int sum = 0;
        // for(Integer i: arr){
        //     sum += i;
        // }

        // if((sum - target) % 2 != 0 || (sum - target) < 0){
        //     return 0;
        // }

        // int total = (sum - target) / 2;

        // return tarSum(arr, n - 1, total);
    }
}
