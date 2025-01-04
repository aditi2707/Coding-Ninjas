import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        // Write your code here.

        int max = 0;

        for(Integer i: arr){
            max = Math.max(max, i);
        }

        return max;
    }
}
