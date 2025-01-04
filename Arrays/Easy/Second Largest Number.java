import java.util.*;
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        int max = a[0], secMax = -1, min = a[0], secMin = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            if(a[i] > max){
                secMax = max;
                max = a[i];
            }
            else if(a[i] > secMax){
                secMax = a[i];
            }

            if(a[i] < min){
                secMin = min;
                min = a[i];
            }
            else if(a[i] < secMin){
                secMin = a[i];
            }
        }

        return new int[]{secMax, secMin};



        // Arrays.sort(a);

        // return new int[]{a[n - 2], a[1]};
    }
}
