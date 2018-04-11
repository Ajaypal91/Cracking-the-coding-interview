package leetCode;

public class _25RevLLGroupsOfK {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
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
				
		int k = 2;
		head = reverseKGroup(head, k);
		
		ListNode curr  = head;
		while(curr != null){
			System.out.print(curr.val + " --> ");
			curr = curr.next;
		}
	}

	
	public static ListNode reverseKGroup(ListNode head, int k) {
        
		ListNode curr = head;
		int count = 0;
		while(curr != null && count != k){
			curr = curr.next;
			count++;
		}
		
		if(count == k){
			
			curr = reverseKGroup(curr, k);
			
			while(count > 0){
				ListNode temp = head.next;
				head.next = curr;
				curr = head;
				head = temp;
				count--;
			}
			head = curr;
		}
		
		return head;
    }
}
