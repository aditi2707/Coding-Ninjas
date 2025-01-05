/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.

        Node fast = head;
        

        for(int i = 0; i < K; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }

        Node slow = head;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;

        return head;







        // Node curr = head;
        // int count = 0;

        // while(curr != null){
        //     count++;
        //     curr = curr.next;
        // }

        // curr = head;

        // if(count == K){
        //     head = head.next;
        //     return head;
        // }

        // while(curr.next != null){
        //     if(count == (K + 1)){
        //         curr.next = curr.next.next;
        //         break;
        //     }
        //     curr = curr.next;
        //     count--;
        // }

        // return head;
    }
}
