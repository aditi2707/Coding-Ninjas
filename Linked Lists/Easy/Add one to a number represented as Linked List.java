import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

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


	public static Node addOne(Node head) {
		// Write your code here.

		head = reverse(head);
		Node curr = head;

		int sum = (curr.data + 1) % 10;
		int carry = (curr.data + 1) / 10;

		curr = curr.next;

		Node add = new Node(sum);

		while(curr != null){
			sum = (curr.data + carry) % 10;
			carry = (curr.data + carry) / 10;

			Node temp = new Node(sum);
			temp.next = add;
			add = temp;

			curr = curr.next;
		}

		if(carry == 1){
			Node temp = new Node(1);
			temp.next = add;
			add = temp;
		}

		return add;
	}
}
