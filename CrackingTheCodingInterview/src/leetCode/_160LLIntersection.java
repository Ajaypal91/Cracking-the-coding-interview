package leetCode;


//this problem approach is similar to finding lowest common ancestor in case of tree when pointer to parent is given.
public class _160LLIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int l1 = getLength(headA);
        int l2 = getLength(headB);
        if(l1 == 0)
            return null;
        if (l2 == 0)
            return null;
        
        if(l1 > l2){
            int diff = l1-l2;
            while(diff!=0){
                diff--;
                headA = headA.next;
            }
        }
        
        if(l2>l1){
            int diff = l2-l1;
            while(diff!=0){
                diff--;
                headB = headB.next;
            }
        }
        
        while(headA!=null && headB != null && headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    public static int getLength(ListNode head){
        
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

}
