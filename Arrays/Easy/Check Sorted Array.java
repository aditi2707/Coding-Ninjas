public class Solution {
    public static int isSorted(int n, int []a) {
        // Write your code here.

        for(int i = 1; i < n; i++){
            if(a[i] < a[i - 1]){
                return 0;
            }
        }

        return 1;
    }
}
