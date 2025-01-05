import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.

        LinkedListNode curr1 = head1;
        LinkedListNode curr2 = head2;
        LinkedListNode head = new LinkedListNode(-1);
        LinkedListNode curr = head;
        
        int carry = 0;

        while(curr1 != null && curr2 != null){

            int sum = (curr1.data + curr2.data + carry) % 10;
            curr.next = new LinkedListNode(sum);

            carry = (curr1.data + curr2.data + carry) / 10;

            curr1 = curr1.next;
            curr2 = curr2.next;
            curr = curr.next;
        }

        while(curr1 != null){
            int sum = (curr1.data + carry) % 10;
            curr.next = new LinkedListNode(sum);

            carry = (curr1.data + carry) / 10;
            curr1 = curr1.next;
            curr = curr.next;
        }

        while(curr2 != null){
            int sum = (curr2.data + carry) % 10;
            curr.next = new LinkedListNode(sum);

            carry = (curr2.data + carry) / 10;
            curr2 = curr2.next;
            curr = curr.next;
        }

        if(carry == 1){
            curr.next = new LinkedListNode(1);
        }

        head = head.next;
        return head;
    }
}
