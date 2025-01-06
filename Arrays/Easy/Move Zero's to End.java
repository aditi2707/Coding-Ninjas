public class Solution {
        public static int[] moveZeros(int n, int []a) {
        // Write your code here.

        int ind = 0;

        for(int i = 0; i < n; i++){
            if(a[i] != 0){
                if(a[ind] == 0){
                    int temp = a[ind];
                    a[ind] = a[i];
                    a[i] = temp;
                }
                ind++;
            }
        }

        return a;








        // int ind = 0;

        // for(Integer i: a){
        //     if(i != 0){
        //         a[ind] = i;
        //         ind++;
        //     }
        // }

        // while(ind < n){
        //     a[ind] = 0;
        //     ind++;
        // }

        // return a;






        // int[] ans = new int[n];
        // int ind = 0;

        // for(Integer i: a){
        //     if(i != 0){
        //         ans[ind] = i;
        //         ind++;
        //     }
        // }

        // return ans;
    }
}
