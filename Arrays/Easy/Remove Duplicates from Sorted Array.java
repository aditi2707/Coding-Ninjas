public class Solution {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.

        int dupli = 0, i = 1;

        while(i < n){
            if(arr[i] == arr[i - 1]){
                int j = i;
                while(j < n && arr[j] == arr[i]){
                    dupli++;
                    j++;
                }
                i = j;
            }
            else{
                i++;
            }
        }

        return n - dupli;
    }
}
