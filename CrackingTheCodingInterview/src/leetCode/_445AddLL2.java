package leetCode;

/*
 * CHECK SOLUTION USING STACK
 */

//https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack
public class _445AddLL2 {
	
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
		ListNode head1 = new ListNode(7);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(5);	
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
	
		node4.next = node5;
		node5.next = node6;
		
		
		printLL(addTwoNumbers(head1, node4));

	}
	
	public static int getCount(ListNode head){
		int count = 0;
		while(head != null){
			head = head.next;
			count++;
		}
		return count;
	}
	
	public static ListNode getNewHead(ListNode head, int count){
		
		
		ListNode newHead = new ListNode(0);
		ListNode curr = newHead;
		newHead.next = head;
		count--;
		while(count != 0){
			ListNode temp = new ListNode(0);
			temp.next = curr;
			count--;
			curr = temp;
		}
		return curr;
		
	}
	
	public static ListNode recAdd(ListNode l1, ListNode l2){
		
		if(l1 == null || l2 == null)
			return null;
		
		ListNode prev = recAdd(l1.next,l2.next);
		int prevVal = 0;
		if (prev!=null)
			prevVal = prev.val/10;
		int sum = l1.val+l2.val + prevVal;
		ListNode temp = new ListNode(sum);
		temp.next = prev;
		if(prev!=null){
			prev.val=prev.val%10;
		}
		
		return temp;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		int n1 = getCount(l1);
		int n2 = getCount(l2);
		
		if(n1>n2){
			l2 = getNewHead(l2, n1-n2);
		}
		if (n2>n1){
			l1 = getNewHead(l1, n2-n1);
		}
		
		ListNode res = recAdd(l1, l2);
		if(res.val/10 > 0){
			ListNode temp = new ListNode(res.val/10);
			res.val %= 10;
			temp.next = res;
			res = temp;
		}
		
		return res;
    }

}
