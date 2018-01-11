package stackAndQueues;

public class Node {
	public int val;
	public Node next;
	
	public Node(int val) {
		this.val = val;
		this.next = null;
	}
	
	public Node nextNode() {
		return this.next;
	}
}
