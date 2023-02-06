/*
 * Video : https://www.youtube.com/watch?v=5BpQ5m0K_t4
 * 
 * Algorithm : 
     1) Initialize the nodes slow and fast to head.
     2) Move forward the fast node by (n-1) positions.
     3) Move forward both the nodes by 'one' position till, fast!=null.
    
 * Expected Time Complexity: O(N).
   Expected Auxiliary Space: O(1).
   
 */
package linkedList1;

public class NthNodeFromEnd {
	linkedList1.Singly.Node head;
	class Node {
		int data;
		Node next;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
	void nthNode(Singly s, int n) {
		linkedList1.Singly.Node slow=s.head;
		linkedList1.Singly.Node fast=s.head;
		if(n<=0) {
			System.out.println("Please Enter a Number greater than Zero...");
			return;
		}
		int count=0;
		while(count<n) {
			if(fast==null){
				System.out.println("N value is greater than length of LL...");
				return;
			}
			fast=fast.next;
			count++;
			
		}
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		System.out.println("Nth node from end is: "+slow.data);
	}

	public static void main(String[] args) {
		int N=1;
		Singly s = new Singly();
		NthNodeFromEnd n= new NthNodeFromEnd();
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.insert(6);
		n.nthNode(s,N);
	}
}
