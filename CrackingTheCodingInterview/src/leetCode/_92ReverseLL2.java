package leetCode;

public class _92ReverseLL2 {

	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	
	public static void printLL(ListNode head){
		
		while(head != null){
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		int m = 1, n = 4;
		
//		printLL(head);
		
		printLL(reverseBetween(head, m, n));
		
	}
	
	//prev is node before the m, prev2 is node at n and curr in the end will be node at n index
	public static ListNode reverseBetween(ListNode head, int m, int n) {
     
		if(head == null)
			return null;
		
		if(head.next == null)
			return head;
		
		int index = 0;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		
		while(index != m-1){
			prev = prev.next;
			curr = curr.next;
			index++;
		}
		
		index = 1; 
		ListNode prev2 = curr; curr = curr.next;
		
		while(index <= n-m){
			ListNode temp = curr.next;
			curr.next = prev2;
			prev2 = curr;
			curr = temp;
			index++;
		}
		
		prev.next.next = curr;
		prev.next = prev2;
		
		if(m == 1)
			head = prev2;
		
		return head;
    }
}
