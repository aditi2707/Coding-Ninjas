import java.util.*;
public class Solution {
    public static int linearSearch(int n, int num, int []arr){
        // Write your code here.

        for(int i = 0; i < n; i++){
            if(arr[i] == num){
                return i;
            }
        }

        return -1;
    }
}
