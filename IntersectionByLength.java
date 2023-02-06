/*
 * Video : https://www.youtube.com/watch?v=_7byKXAhxyM
 * 
 * Algorithm :
     1) Calculate length of both LinkedLists as L1 and L2.
     2) Calculate the difference d=l1-l2.
     3) Move d nodes in longer linked list.
     4) Then move by both LinkedLists in one step till p==q(nodes in both LL).
  
 * Expected Time Complexity: O(N+M)
   Expected Auxiliary Space: O(1)
   
 */
package linkedList1;
//import linkedList.Singly;
public class IntersectionByLength {
	linkedList1.Singly.Node head;
	class Node {
		int data;
		Node next;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
	void intersection(Singly s,Singly s1) {
		linkedList1.Singly.Node a = s.head;
		linkedList1.Singly.Node b = s1.head;
		int l=s.length();
		int l1=s1.length();
		int diff= (l1>l)?(l1-l):(l-l1);
		//System.out.println(diff);
		//System.out.println("head1:"+a.data);
		//System.out.println("head2:"+b.data);
		int flag=0;
		int c=0;
		if(l>l1) {
			while( c<diff){
			a=a.next;
			//System.out.println("a:"+a.data);
			c++;
			//System.out.println("c1:"+c);
		   }
		}
		else {
			while(c<diff){
				b=b.next;
				//System.out.println("a:"+a.data);
				c++;
				//System.out.println("c2:"+c);
			   }
		}
		//System.out.println("head11:"+a.data);
		//System.out.println("head22:"+b.data);
		while(a!=null && b!=null) {
			if(a.data==b.data) {
				System.out.println("Intersection Point is: "+a.data);
				flag=1;
				break;
			}
			a=a.next;
			b=b.next;
		}
		if(flag==0) {
			System.out.println("There is no Intersection point...");
		}
	}
	
	public static void main(String[] args) {
		Singly s = new Singly();
		Singly s1 = new Singly();
		IntersectionByLength l= new IntersectionByLength();
		
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.insert(6);
		s.insert(7);
		s1.insert(8);
		s1.insert(9);
		s1.insert(5);
		s1.insert(6);
		s1.insert(7);
		l.intersection(s,s1); //Passing linked list

	}
}
