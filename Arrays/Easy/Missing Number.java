import java.util.*;
public class Solution {

    public static int missingNumber(int []nums, int N) {
        // Write your code here.

        int xor = 0;

        for(int i = 1; i <= N; i++){
            xor ^= i;
        }

        for(Integer i: nums){
            xor ^= i;
        }

        return xor;






        // int totalSum = (N * (N + 1)) / 2;

        // int sum = 0;
        // for(Integer i: nums){
        //     sum += i;
        // }

        // return totalSum - sum;
    }
}
