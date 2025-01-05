import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.

        int[] rotate = new int[k];
        int index = 0;

        for(int i = 0; i < k; i++){
            rotate[i] = arr.get(i);
        }

        for(int i = k; i < arr.size(); i++){
            arr.set(index, arr.get(i));
            index++;
        }

        for(int i = 0; i < k; i++){
            arr.set(index, rotate[i]);
            index++;
        }

        return arr;
    }
}
