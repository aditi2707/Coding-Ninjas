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

    private static Node reverse(Node slow){

        Node prev = null;
        Node curr = slow;

        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        slow = prev;
        return slow;
    }
    public static boolean isPalindrome(Node head) {
        // write your code here

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        Node curr = head;

        slow = reverse(slow);

        while(slow != null){
            if(curr.data != slow.data){
                return false;
            }
            curr = curr.next;
            slow = slow.next;
        }

        return true;









        // Node curr = head;
        // List<Integer> list = new ArrayList<>();

        // while(curr != null){
        //     list.add(curr.data);
        //     curr = curr.next;
        // }

        // for(int i = 0; i <= list.size()/2; i++){
        //     if(!list.get(i).equals(list.get(list.size() - 1 - i))){
        //         return false;
        //     }
        // }

        // return true;
    }
}
