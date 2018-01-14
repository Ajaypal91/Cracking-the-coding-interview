package linkedLists;

import java.util.Scanner;

public class _4AddTwoNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Create Linked List and enter 0 to stop");
		
		LinkedList l1 = new LinkedList();
		
		int n = sc.nextInt();
		
		while (n != 0) {
			l1.insertAtEnd(n);
			n = sc.nextInt();
		}
		
		l1.printLinkedList();
		
		System.out.println("Create Linked List and enter 0 to stop");
		
		LinkedList l2 = new LinkedList();
		
		n = sc.nextInt();
		
		while (n != 0) {
			l2.insertAtEnd(n);
			n = sc.nextInt();
		}
		
		l2.printLinkedList();
		
		
		LinkedList l3 = addTwoNumbers(l1,l2);
		
		l3.printLinkedList();
		l3 = new LinkedList();
		addNumbersRec(l1.head,l2.head, 0, l3);
		
		l3.printLinkedList();
		
		Node head = addNumbersFollowUpQ(l1.head, l2.head);
		
		while (head!=null){
			System.out.print(head.val+" --> ");
			head = head.next;
		}
		System.out.println("null");
		
		sc.close();
	}

	private static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {
		
		int carry = 0;
		LinkedList res = new LinkedList();
		Node h1 = l1.head;
		Node h2 = l2.head;
		
		if (h1 == null)
			return l2;
		if (h2 == null)
			return l1;
		
		int temp = 0;
		while (h1 != null && h2 != null){
			
			temp = carry + h1.val + h2.val;
			carry = temp/10;
			temp = temp%10;
			res.insertAtEnd(temp);
			h1 = h1.next;
			h2 = h2.next;
		}
		
		while(h1 != null){
			temp = carry + h1.val;
			carry = temp/10;
			temp = temp%10;
			res.insertAtEnd(temp);
			h1 = h1.next;
		}
		
		while(h2 != null){
			temp = carry + h2.val;
			carry = temp/10;
			temp = temp%10;
			res.insertAtEnd(temp);
			h2 = h2.next;
		}
		if (carry > 0)
			res.insertAtEnd(carry);
		
		return res;
	}
	
	private static void addNumbersRec(Node n1, Node n2, int carry, LinkedList res){
		
		
		if (n1 != null && n2 != null){
			int temp = n1.val + n2.val + carry;
			carry = temp/10;
			temp = temp%10;
			res.insertAtEnd(temp);
			addNumbersRec(n1.next, n2.next, carry, res);
		}
		
		else if(n1!=null){
			int temp = n1.val + carry;
			carry = temp/10;
			temp = temp%10;
			res.insertAtEnd(temp);
			addNumbersRec(n1.next, n2, carry, res);
		}
		
		else if(n2!=null){
			int temp = n2.val + carry;
			carry = temp/10;
			temp = temp%10;
			res.insertAtEnd(temp);
			addNumbersRec(n1, n2.next, carry, res);
		}
		
		else if (carry > 0){
			res.insertAtEnd(carry);
		}
		
	}
	
	private static Node addNumbersFollowUpQ(Node n1, Node n2){
		
		int l1 = 0;
		Node curr = n1;
		while(curr != null){
			l1+=1; curr = curr.next;
		}
		
		int l2 = 0;
		curr = n2;
		while(curr != null){
			l2+=1; curr = curr.next;
		}
		
		Node curr1 = n1; Node curr2 = n2;
		if (l1 > l2){
			int l = l1-l2;
			while(l!=0){
				Node n = new Node(0);
				n.next = curr2;
				curr2 = n;
				l-=1;
			}
			n2 = curr2;
		}
		if(l2 > l1){
			int l = l2-l1;
			while(l!=0){
				Node n = new Node(0);
				n.next = curr1;
				curr1 = n;
				l-=1;
			}
			n1 = curr1;
		}
		
		Node head = addNumRec(n1, n2);
		
		if (head.val >= 10){
			Node n = new Node(head.val/10);
			head.val = head.val%10;
			n.next = head;
			head = n;
		}
		
		return head;
	}
	
	private static Node addNumRec(Node n1, Node n2){
		
		if (n1 == null || n2 == null){
			return null;
		}
		
		Node n = addNumRec(n1.next, n2.next);
		
		int sum = n1.val+n2.val;
		if(n!=null){
			sum += n.val/10;
			n.val = n.val%10;
		}
		
		Node currNode = new Node(sum);
		currNode.next = n;
		return currNode;
		
	}

}
