/*
 * Video : https://www.youtube.com/watch?v=icnp4FJdZ_c
 *
 * Algorithm:
       1) Here, in deleting data place, we store the next data of deleting data.
       2) Here, we are we are connecting current node address to next.next node. 
       
 */
package linkedList1;

public class DeleteNodeWithoutHead {
	linkedList1.Singly.Node head;
	static class Node {
		int data;
		Node next;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	// Here, we are not deleting the node,updating the value
	void delete(linkedList1.Singly.Node node) {
		if(node.next==null) { //If last node to be deleted
			return;
		}
		node.data=node.next.data; // In four we are storing next data(4==5)
		node.next=node.next.next; //we are connecting current node address to next node address[4(5)-->6].
	}

	public static void main(String[] args){
		Singly s = new Singly();
		DeleteNodeWithoutHead d= new DeleteNodeWithoutHead();
		s.insert_returnNode(1);
		s.insert_returnNode(2);
		s.insert_returnNode(3);
		linkedList1.Singly.Node node4 = s.insert_returnNode(4);
		s.insert_returnNode(5);
		//s.insert_returnNode(6);
		s.print();
		d.delete(node4);
		System.out.println();
		s.print();

	}
}
