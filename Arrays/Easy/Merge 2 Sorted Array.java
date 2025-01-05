import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        if(a[0] < b[0]){
            list.add(a[0]);
            i++;
        }
        else if(a[0] == b[0]){
            list.add(b[0]);
            i++;
            j++;
        }
        else{
            list.add(b[0]);
            j++;
        }

        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                if(list.get(list.size() - 1) != a[i]){
                    list.add(a[i]);
                }
                i++;
            }
            else if(a[i] == b[j]){
                if(list.get(list.size() - 1) != b[j]){
                    list.add(b[j]);
                }
                i++;
                j++;
            }
            else{
                if(list.get(list.size() - 1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }
        }

        while(i < a.length){
            if(list.get(list.size() - 1) != a[i]){
                list.add(a[i]);
            }
            
            i++;
        }
        while(j < b.length){
            if(list.get(list.size() - 1) != b[j]){
                list.add(b[j]);
            }
            
            j++;
        }

        return list;
    }
}
