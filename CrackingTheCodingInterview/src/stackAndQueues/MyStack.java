package stackAndQueues;

public class MyStack {
	Node top;
	
	public void push(int val){
		Node newNode = new Node(val);
		newNode.next = top;
		top = newNode;
	}
	
	public Node pop(){
		if (top != null){
			Node t = top;
			top = top.next;
			return t;
		}
		return null;
	}
}
