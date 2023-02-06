/*
 * Link : https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 * Video : https://www.youtube.com/watch?v=zbozWoMgKW0
 * 
 * Algorithm : 
 * Method 2 (Better Solution)  

	1)This method is also dependent on Floyd’s Cycle detection algorithm.
	2)Detect Loop using Floyd’s Cycle detection algorithm and get the pointer to a loop node.
	3)Count the number of nodes in loop. Let the count be k.
	4)Fix one pointer to the head and another to a kth node from the head.
	5)Move both pointers at the same pace, they will meet at loop starting node.
	6)Get a pointer to the last node of the loop and make next of it as NULL.
	
 * Complexity Analysis:  
	Time complexity: O(n). 
	Only one traversal of the loop is needed.
	Auxiliary Space:O(1). 
	There is no space required.	
	
 */
package linkedList1;


public class DetectAndRemoveLoop {
	//static Singly s = new Singly();
	linkedList1.Singly.Node head;
	linkedList1.Singly.Node detectPrev = null;
	 linkedList1.Singly.Node store = null;
	static class Node {
		int data;
		Node next;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
		
	linkedList1.Singly.Node detectingLoop(linkedList1.Singly.Node head) { //Efficient Approach
		System.out.println("head:"+head.data);
		linkedList1.Singly.Node slow = null;
	    linkedList1.Singly.Node fast = null;
        slow = head;
		fast = head;
		
		while(slow!=null && fast!=null && fast.next!=null){
			// Get's the previous node, for edge case
			// here, as we are storing the value before incrementing the slow
			// previous value of slow, will be stored
			detectPrev = slow;
			//System.out.println("detectPrev1: "+detectPrev.data);
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				System.out.println("Slow and Fast: "+slow.data);
				return fast;
			}
		}
		return null;
	}
	
	
	void removeLoop(Singly s) {
		//System.out.println("head:"+s.head.data);
		linkedList1.Singly.Node fast = detectingLoop(s.head);
		store=detectingLoop(s.head);
		linkedList1.Singly.Node prev = null; 
	    linkedList1.Singly.Node slow=s.head;
		System.out.println("Fast: "+fast.data+","+"Slow: "+slow.data);
		if(fast == slow) { // Edge case
			// When last node connected to first, both will be at first position.
			// here, we get the value from detect loop
			//System.out.println("detectPrev:"+detectPrev.data);
			detectPrev.next = null;
			System.out.println("LOOP");
			return;
		}
		while(fast!=slow) {
			System.out.println("fast: "+fast.data);
			prev=fast;
			fast=fast.next;
			slow=slow.next;
		}
		prev.next=null;
	}
	
	
	linkedList1.Singly.Node startLoop(Singly s) {
		linkedList1.Singly.Node fast = s.head;
		linkedList1.Singly.Node prev = null; 
	    linkedList1.Singly.Node slow=detectPrev;
		System.out.println("Fast: "+fast.data+","+"Slow: "+slow.data);
		
		while(fast!=slow) {
			System.out.println("fast: "+fast.data);
			prev=fast;
			fast=fast.next;
			slow=slow.next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		Singly s = new Singly();
		
		DetectAndRemoveLoop d= new DetectAndRemoveLoop();
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.insert(6);
		s.insert(7);
		s.insert(8);
		s.insert(9);
		s.insert(10);
		s.print();
		
		System.out.println();
		
		/*Creating loop for testing */
		s.head.next.next.next= s.head; // 4-->2
		System.out.println("Elements according to Address:");
		System.out.println(s.head.data); //1
		System.out.println(s.head.next.data); //2
		System.out.println(s.head.next.next.data); //3
		System.out.println(s.head.next.next.next.data); //4
		//NORMALLY, WE CREATE LOOP FROM LAST TO FIRST
		//IF WE CREATE IN BETWEEN THEN ELEMENTS AFTER THAT LOOP WON'T EXIST
		//CHECK OUTPUT FOR YOUR REFERENCE
		System.out.println(s.head.next.next.next.next.next.next.next.next.next.data); //2
		//System.out.println("Is Loop Found: "+s.head.data);
		//System.out.println("Is Loop Found: "+d.detectingLoop(s.head).data);
	
		d.removeLoop(s);
		//linkedList1.Singly.Node Start=d.startLoop(s);
		//System.out.println("Starting Point: "+Start.data);
		s.print();
	}
}
