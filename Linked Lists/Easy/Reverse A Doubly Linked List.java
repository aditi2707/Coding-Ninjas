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
    public static Node reverseDLL(Node head)
    {
        // Write your code here.

        Node curr = head;

        while(curr.next != null){

            Node temp = curr.next;
            Node prev = curr.prev;
            Node next = curr.next;
            curr.next = prev;
            curr.prev = next;

            curr = temp;
        }

        Node prev = curr.prev;
        curr.next = prev;
        curr.prev = null;

        head = curr;

        return head;
    }
}
