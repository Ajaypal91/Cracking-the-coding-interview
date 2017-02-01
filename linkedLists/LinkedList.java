package linkedLists;

public class LinkedList {
	
	public Node head;
	
	public void insertAtEnd(int val) {
		
		Node n = new Node(val);
		
		if (head == null) {
			head = n;
			return;
		}
		else {
			Node curr = head;
			
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = n;			
		}
	}
	
	public void insertAtBeg(int val) {
		Node n = new Node(val);
		
		if (head == null) {
			head = n;
			return;
		}
		else {
			n.next = head;
			head = n;
		}
	}
	
	public void printLinkedList() {
		Node curr = head;
		
		while (curr != null) {
			System.out.print(curr.val + " --> ");
			curr = curr.nextNode();
		}
		System.out.print("null\n");
	}
	
}
