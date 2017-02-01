package linkedLists;

import java.util.HashMap;
import java.util.Scanner;

public class _1removeDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Create Linked List and enter 0 to stop");
		
		//assuming elements are all integers
		myLinkedList l = new myLinkedList();
		
		int n = sc.nextInt();
		
		while (n != 0) {
			l.insertAtEnd(n);
			n = sc.nextInt();
		}
		
		l.printLinkedList();
		
		System.out.println("Removing duplicates");
		
		//comment this and comment out other method to test that
		l.removeDuplicatesUsingHashMap();
		
//		l.removeDuplicatesWithoutBuffer();
		
		l.printLinkedList();
		
		sc.close();
	}

}

class myLinkedList extends LinkedList {

	public void removeDuplicatesUsingHashMap() {
		// TODO Auto-generated method stub
		HashMap<Integer, Boolean> dic = new HashMap<Integer,Boolean>();
		
		Node curr = head;
		
		//remove duplicates
		curr = head;
		Node prev = head;
		while(curr != null) {
			if (dic.containsKey(curr.val)) {
				if (curr == head) {
					head = head.nextNode();
					curr = head;
					prev = head;
				}
				else {
					prev.next = curr.next;
				}
				curr = prev.nextNode();
			}
			else {
				dic.put(curr.val, true);
				prev = curr;
				curr = curr.nextNode();
			}
		}
		
		dic.clear();
		System.gc();
		
	}

	public void removeDuplicatesWithoutBuffer() {
		// TODO Auto-generated method stub
		Node curr = head, prev = head;
		
		while(curr != null) {
			if (isDuplicatePresent(curr.nextNode(), curr.val)) {
				if (curr == head) {
					head = head.nextNode();
					curr = head;
					prev = curr;
				}
				else {
					prev.next = curr.nextNode();
					curr = curr.nextNode();
				}
			}
			else {
				prev = curr;
				curr = curr.nextNode();
			}
			
		}
		
	}
	//helper method for removeDuplicatesWithoutBuffer
	public boolean isDuplicatePresent(Node n, int val) {
		
		while(n != null) {
			if (n.val == val) {
				return true;
			}
			n = n.nextNode();
		}
		
		return false;
	}
	
	
	
	
	
}
