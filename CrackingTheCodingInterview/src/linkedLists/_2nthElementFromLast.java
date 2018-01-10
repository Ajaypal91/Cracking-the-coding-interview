package linkedLists;

import java.util.Scanner;

public class _2nthElementFromLast {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Create Linked List and enter 0 to stop");
		
		LinkedList l = new LinkedList();
		
		int n = sc.nextInt();
		
		while (n != 0) {
			l.insertAtEnd(n);
			n = sc.nextInt();
		}
		
		l.printLinkedList();
		
		System.out.println("input n");
		n = sc.nextInt();
		
		System.out.println(getNthElementFromLast(l.head, n));
		System.out.println(getNthUsingPointers(l.head, n));
		
		l.printLinkedList();
		
		sc.close();

	}

	private static int getNthElementFromLast(Node head,int n){
		
		int l = 0;
		Node curr = head;
		while(curr != null){
			l+=1;
			curr = curr.next;
		}
		curr = head;
		for (int i = 0; i < (l-n) ; i++){
			curr = curr.next;
		}
		return curr.val;
	}
	
	//Assuming atleast n nodes
	private static Integer getNthUsingPointers(Node head, int n){
		
		if (head == null || n < 0)
			return null;
		
		Node curr = head, fast = head;
		int l = n;
		
		while(l != 0){
			fast = fast.next;
			l--;
		}
		
		while(fast!=null){
			curr = curr.next;
			fast = fast.next;
		}
		
		return curr.val;
	}
}
