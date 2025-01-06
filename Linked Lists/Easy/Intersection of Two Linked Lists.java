/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

import java.util.*;
public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here

        Node a = firstHead;
        Node b = secondHead;

        while(a != b){
            if(a == null){
                a = secondHead;
            }
            if(b == null){
                b = firstHead;
            }

            a = a.next;
            b = b.next;
        }

        return a.data;






        // Set<Node> set = new HashSet<>();

        // Node curr = firstHead;

        // while(curr != null){
        //     set.add(curr);
        //     curr = curr.next;
        // }

        // curr = secondHead;

        // while(curr != null){
        //     if(set.contains(curr)){
        //         return curr.data;
        //     }
        //     curr = curr.next;
        // }

        // return -1;
    }
}
