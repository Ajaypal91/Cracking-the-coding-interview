package stackAndQueues;

public class SimpleStack {
	
	int top;
	int[] arr;
	
	public SimpleStack() {
		this.top = -1;
		this.arr = new int[300];
	}
	
	public void push(int val) {
		if (top == 299) {
			System.out.println("Overflow. Exiting!");
			return;
		}
		else {
			arr[top] = val;
			top += 1;
		}
	}

	public int pop() {
		if (top == -1){
			System.out.println("Underflow. Exiting!");
			return -1;
		}
		int val = arr[top];
		top -= 1;
		return val;
	}
	
}
