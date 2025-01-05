import java.util.* ;
import java.io.*; 


public class Solution {

    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.

        int left = arr[0];

        for(int i = 1; i < n; i++){
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = left;

        return arr;
    }
}
