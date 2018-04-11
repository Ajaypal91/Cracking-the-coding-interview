package leetCode;

import java.util.Stack;
//https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
public class _155MinStkDriver {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		System.out.println(obj.minStk);
		System.out.println(obj.stk);
		obj.pop();
		System.out.println("After Pop");
		System.out.println(obj.minStk);
		System.out.println(obj.stk);
//		System.out.println(obj.getMin());
		obj.pop();
		System.out.println("After Pop");
		System.out.println(obj.minStk);
		System.out.println(obj.stk);
//		System.out.println(obj.getMin());
		obj.pop();
		System.out.println("After Pop");
		System.out.println(obj.minStk);
		System.out.println(obj.stk);
//		System.out.println(obj.getMin());
	}

}

class MinStack {

    Stack<Integer> minStk, stk;
    
    /** initialize your data structure here. */
    public MinStack() {
        
        minStk = new Stack<>();
        stk = new Stack<>();
        
    }
    
    public void push(int x) {
        
        if(minStk.size()>0){
            Integer minSoFar = minStk.peek();
            if(minSoFar >= x)
                minStk.push(x);
            
        }
        else{
            minStk.push(x);
        }
        stk.push(x);
    }
    
    public void pop() {
        
        if(stk.size() > 0){
        	System.out.println(minStk.peek());
        	System.out.println(stk.peek());
            if(minStk.peek().equals(stk.peek())){
                minStk.pop();
            }
            stk.pop();
        }
    }
    
    public int top() {
        if(stk.size()>0)
            return stk.peek();
        return 0;
    }
    
    public int getMin() {
        if(minStk.size() > 0)
            return minStk.peek();
        return 0;
    }
}