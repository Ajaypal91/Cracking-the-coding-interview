package leetCode;

public class _234ISPalindromLL {

	private static boolean isPalin = true;
	private static boolean stopRec = false;
	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(1);
//		ListNode node4 = new ListNode(1);
		head.next = node1;
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
		
		System.out.println(isPalindrome(head));
		
	}
	
	public static boolean isPalindrome(ListNode head) {
        
		palCheck(head, head);
		return isPalin;
    }
	
	public static ListNode palCheck(ListNode head, ListNode curr){
		
		if(curr == null){
			return head;
		}
		
		ListNode first = palCheck(head, curr.next);
		
		if(!stopRec){
			if(first.val != curr.val)
				isPalin = false;
		}
		if(first.next == curr || first == curr)
			stopRec = true;
		return first.next;
	}
	

}
