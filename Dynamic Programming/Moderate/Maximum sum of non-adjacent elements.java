import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {

	public static int findSum(int n, ArrayList<Integer> nums, int[] dp){

		if(n == 0){
			return nums.get(0);
		}
		if(n == 1){
			return Math.max(nums.get(0), nums.get(1));
		}

		if(dp[n] != -1){
			return dp[n];
		}

		int choose = nums.get(n) + findSum(n - 2, nums, dp);
		int notChoose = findSum(n - 1, nums, dp);

		dp[n] = Math.max(choose, notChoose);
		return dp[n];
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {

		if(nums.size() == 1){
			return nums.get(0);
		}
		if(nums.size() == 1){
			return Math.max(nums.get(0), nums.get(1));
		}

		int pick = nums.get(0);
		int notPick = Math.max(nums.get(0), nums.get(1));

		for(int i = 2; i < nums.size(); i++){
			int choose = nums.get(i) + pick;
			int notChoose = notPick;

			int curr = Math.max(choose, notChoose);
			pick = notPick;
			notPick = curr;
		}

		return notPick;









		
		// int[] dp = new int[nums.size()];
		// Arrays.fill(dp, -1);

		// if(nums.size() == 1){
		// 	return nums.get(0);
		// }
		// if(nums.size() == 1){
		// 	return Math.max(nums.get(0), nums.get(1));
		// }

		// dp[0] = nums.get(0);
		// dp[1] = Math.max(nums.get(0), nums.get(1));

		// for(int i = 2; i < nums.size(); i++){
		// 	int choose = nums.get(i) + dp[i - 2];
		// 	int notChoose = dp[i - 1];

		// 	dp[i] = Math.max(choose, notChoose);
		// }

		// return dp[nums.size() - 1];









		// return findSum(nums.size() - 1, nums, dp);
	}
}
