package linkedLists;

import java.util.Scanner;

public class _5RemoveLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter node number to connect to loop");
		
		int num = sc.nextInt();
		
		System.out.println("Create Linked List and enter 0 to stop");
		
		LinkedList l1 = new LinkedList();
		
		int n = sc.nextInt();
		
		while (n != 0) {
			l1.insertAtEnd(n);
			n = sc.nextInt();
		}
		
		Node numNode = l1.getNodeAt(num);
		Node last = l1.getLastNode();
		last.next = numNode;
		
		removeLoop(l1.head);
		
		l1.printLinkedList();
		
		sc.close();
	}
	
	private static void removeLoop(Node head){
		
		Node slow = head, fast = head;
		slow = slow.next;
		fast = fast.next.next;
		while(fast != slow){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		slow = head.next;
		Node prev = fast;
		fast = fast.next;
		while(slow != fast){
			slow = slow.next;
			prev = fast;
			fast = fast.next;			
		}
		prev.next = null;
	}

}
