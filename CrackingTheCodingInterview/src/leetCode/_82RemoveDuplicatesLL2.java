package leetCode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
public class _82RemoveDuplicatesLL2 {
	
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
	}
	
	 public static ListNode deleteDuplicates(ListNode head) {
	        
	        if(head == null)
	            return null;
	        if(head.next == null)
	            return head;
	        
	        ListNode curr = head, prev = null;
	        
	        //skip duplicate values at starting
	        int prevVal = head.val;
	        curr = head.next;
	        while(prevVal == curr.val){
	            
	            while(head != null && head.val == prevVal){
	                head = head.next;
	            }
	            if(head == null)
	                return null;
	            if(head.next == null)
	                return head;
	            prevVal = head.val;
	            curr = head.next;
	        }
	        
	        //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
	        //check above solution can add dummy node in front instead to skip previous part
	        //rest logic is same
	        prev = head;
	        while(curr != null){
	            
	            prevVal = curr.val;
	            boolean same = false;
	            while(curr.next != null && curr.next.val == prevVal){
	                curr = curr.next;
	                same = true;
	            }
	            
	            if(same){
	                prev.next = curr.next;
	            }
	            else{
	                prev = curr;
	            }
	            curr = curr.next;
	            if(curr == null || curr.next == null) // case [1 --> 2]
	                break;
	            
	        }
	        
	        return head;
	        
	    }

}
