package linkedLists;

import java.util.Scanner;

public class _3RemoveMiddle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter n");
		int m = sc.nextInt();
		System.out.println("Create Linked List and enter 0 to stop");
		
		LinkedList l = new LinkedList();
		
		int n = sc.nextInt();
		
		while (n != 0) {
			l.insertAtEnd(n);
			n = sc.nextInt();
		}
		
		l.printLinkedList();
		
		Node curr = l.head;
		for (int i= 0; i < m/2;i++)
			curr= curr.next;
		
		removeMiddleNode(curr);
		
		l.printLinkedList();
		
		sc.close();

	}

	private static boolean removeMiddleNode(Node middle) {
		
		if (middle == null || middle.next == null)
			return false;
		middle.val = middle.next.val;
		middle.next = middle.next.next;
		
		return true;
		
	}

}
