package linkedLists;

import java.util.Scanner;

public class _5ArrangeLL {

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
		
		l.head = rearrangeLL(l.head,m);
		
		l.printLinkedList();

	}

	private static Node rearrangeLL(Node head, int x){
		
		Node curr = head, lastSmall = head, lastLargest = head;
		Node prev = null;
		
		while(curr != null && curr.val <= x){
			prev = curr;
			curr = curr.next;
		}
		
		lastLargest = curr;
		lastSmall = prev;
		
		while(curr != null){
			
			if (curr.val <= x){
				if (lastSmall == null){
					lastLargest.next = curr.next;
					Node temp = curr;
					temp.next = head;
					lastSmall = temp;
					head = temp;
					curr = lastLargest;
				}
				else{
					Node temp = curr.next;
					lastLargest.next = temp;
					curr.next = lastSmall.next;
					lastSmall.next = curr;
					lastSmall = curr;
					curr = lastLargest;
				}
				
			}
			else{
				lastLargest = curr;
			}
			
			curr = curr.next;
		}
		
		return head;
	}
	
}
