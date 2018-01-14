package stackAndQueues;

public class _2FindMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Stack {
	public int top;
	public int min;
	public Node[] stk;
	
	public Stack(){
		this.top = -1;
		this.stk = new Node[300];
	}
	
	public void push(int val) {
		if (top == 299) {
			System.out.println("Overflow. Exiting!");
			return;
		}
		else {
			
		}
	}
	
}
