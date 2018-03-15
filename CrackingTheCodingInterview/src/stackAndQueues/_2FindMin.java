package stackAndQueues;

import java.util.Stack;

public class _2FindMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myStack stk = new myStack();
	}

}

@SuppressWarnings("serial")
class myStack extends Stack<Integer> {
	
	Stack<Integer> minStack;
	
	myStack(){
		minStack = new Stack<>();
	}
	
	public void push(int val) {
		
		if (val < min())
			minStack.push(val);
		super.push(val);
	}
	
	public Integer pop() {
		if(min() == super.peek())
			minStack.pop();
		return super.pop();
	}
	
	public int min() {
		if (minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
	
}
