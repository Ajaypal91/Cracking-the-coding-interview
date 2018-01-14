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
	
	public Node getNodeAt(int n){
		Node curr = head;
		n-=1;
		while(n!=0){
			curr = curr.next;
			n-=1;
		}
		return curr;
	}
	
	public Node getLastNode(){
		Node curr = head;
		while(curr.next != null)
			curr = curr.next;
		return curr;
	}
	
}
