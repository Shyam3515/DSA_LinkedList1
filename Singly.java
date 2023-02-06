package linkedList1;

public class Singly {
	static class Node{
		int data; // value--> Int data type
		// address of next node
		Node next; // But this is of Node DT only,bcz this will hold the address of another node
		
		/*In c programming we use pointers, but what we do in java is we create reference of next object
		  Ofcourse this node is also a object
		  First Object will have the reference of second object and second will have third.
		  We don't have any object at last, so that will be null.*/
		
		// Linked list Node.
	    // This inner class is made static
	    // so that main() can access it
		Node(int data){
			this.data = data;
			next= null;
		}
	}

	//Inserting a node at (start(if head== null)) end(by default).
	Node head; // First node will be head node
	void insert(int data) { 
		// Every time we say insert, we are creating a new node here
		Node newnode = new Node(data);
		newnode.data=data;// Whatever we pass come here,if we say 5, node gets 5.
		newnode.next = null;// no problem, even if we dont add this,
		                    // bcz, by default value of object is null	
		if(head==null) {
			head = newnode; //if,head=null make head as first node 
			return;
		}
		
		else {
			Node temp=head;// created temp, to hold data, to travel from first to insert position
			while(temp.next!=null) {
				temp=temp.next;// jumps to next node until we got position
			}
			temp.next=newnode; //After reaching that position, temp holds new node
			//Ex: if you are at 2nd position, 2nd position(next) holds new node address
		}
	}
	Node insert_returnNode(int data) { 
		// Every time we say insert, we are creating a new node here
		Node newnode = new Node(data);
		newnode.data=data;// Whatever we pass come here,if we say 5, node gets 5.
		newnode.next = null;// no problem, even if we dont add this,
		                    // bcz, by default value of object is null	
		if(head==null) {
			head = newnode; //if,head=null make head as first node 
			return null;
		}
		
		else {
			Node temp=head;// created temp, to hold data, to travel from first to insert position
			while(temp.next!=null) {
				temp=temp.next;// jumps to next node until we got position
			}
			temp.next=newnode; //After reaching that position, temp holds new node
			//Ex: if you are at 2nd position, 2nd position(next) holds new node address
		}
		return newnode;
	}
	
	//Inserting at start
	void insertingAtStart(int data) {
		Node newnode = new Node(data);
		newnode.data=data;
		newnode.next = null;
		newnode.next = head; // here we are making newnode to point head, as head is first one
		head=newnode; // here we are making head to point newnode, so it becomes first node
	}
	
	//Insert In Between
	void insertingInBetween(int index,int data) {
		Node newnode = new Node(data);
		newnode.data=data;
		newnode.next = null;
		
		if(index==0) { // if entered index is at 0, then call atstart condition
			insertingAtStart(data);
		}
		else {
			Node n = head; // created n, to hold data, to travel from first to insert position
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
				newnode.next = n.next; //This is taking the address of nextnode of newnode from previous of newnode.
				n.next=newnode; //making current position.next to point to newnode
			}
	}
	
	//Deleting Elements
	void delete(int index) {
		Node n1=null;
		if(index==0) {
			n1=head;// Storing data of head in n1.
			head = head.next;
			System.out.println("The deleted element is: "+n1.data);
			System.out.println("After deleting Number of nodes present are : "+length());
		}
		else {
			Node n = head; // created n, to hold data, to travel from first to insert position
			Node n2=null;
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
			n2=n.next;// here n2 is the deleting element, n is the previous one
			n.next=n2.next; //here we are assigning the address (next of deleting element) to (previous of deleting element).
			System.out.println("The deleted element is: "+n2.data);
			System.out.println("After deleting Number of nodes present are : "+length());
			n2=null; // Even though we delinked, that object still exists, to delete it we are making null
		}
	}
	
	//Peek element
	void peek() {
		Node n1=head;
		System.out.print("The top most element is : ");
		if(head==null) {
			System.out.println(0);
		}
		else {
			System.out.println(n1.data);
		}
	}
	
	//Number of nodes
		int length() {
			int count=0;
			Node p=head;
			while(p!=null) {
				count+=1;
				p=p.next;
			}
			return count;
		}

	//Printing data
	public void print() {
		Node temp=head; //As we have to traverse from first
		System.out.println("Elements in Linked List are:");
		while(temp!=null) {// Traverse to last position
			// Prints data that is present in temp.
			System.out.print(temp.data +" ");
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		Singly l = new Singly();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(5);
		l.insertingAtStart(0);
		l.insertingInBetween(4, 4);
		System.out.println("Number of nodes present are : "+l.length());
		l.delete(4);
		l.delete(0);
		System.out.println("Number of nodes present are : "+l.length());
		l.peek();
		l.print();

	}

}
