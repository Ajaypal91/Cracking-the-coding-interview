package linkedLists;

import java.util.Scanner;
import java.util.Stack;

public class _7IsPalindrome {

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
		
//		PadlindromTuple res = isPalindromeRec(l.head, l.head);
	
//		System.out.println(res.status);
		
		System.out.println(isPalindromeIter(l.head));
		
	}
	
	private static PadlindromTuple isPalindromeRec(Node head, Node fast){
		
		if (fast == null){
			PadlindromTuple t = new PadlindromTuple();
			t.start = head;
			t.status = true;
			t.middleReached = false;
			return t;
					
		}
		
		PadlindromTuple p = isPalindromeRec(head, fast.next);
		
		//stop when the comparisons are made till middle element the fast will be equal to curr(even case) other wise fast
		//would have crossed the curr
		if (!p.middleReached && fast != p.start.next && fast != p.start){
			if (p.start.val != fast.val){
				p.status = false;
			}
			else{
				p.status = p.status & true;
			}
			p.start = p.start.next;
		}
		else{
			p.middleReached = true;
		}
		
		return p;
	}
	
	private static boolean isPalindromeIter(Node head){
		
		boolean isPalindrome = true;
		
		Node slow = head, fast = head;
		
		Stack<Integer> stk = new Stack<>();
		
		
		while (fast != null && fast.next != null){
			stk.push(slow.val);
			slow = slow.next; 
			fast = fast.next.next;
		}		
		
		if (fast != null && fast.next == null){//for odd length
			slow = slow.next;
		}
		
		while(slow!=null){
			if(stk.pop() != slow.val){
				isPalindrome = false;
				break;
			}
			slow = slow.next;
		}
		
		return isPalindrome;
	}

}


class PadlindromTuple{
	boolean middleReached;
	boolean status;
	Node start;
}