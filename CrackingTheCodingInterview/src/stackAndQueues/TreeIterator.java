package stackAndQueues;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<TreeNode>{

	Stack<TreeNode> stk;
	Boolean left, right, processed;
	TreeNode root;
	TreeNode result;
	
	public TreeIterator(TreeNode root){
		
		stk = new Stack<>();
		this.root = root;
		left = false;
		right = false;
		result = null;
		processed = false;
	}

	public void traverse(){
		
		if(stk.isEmpty() && !processed){
			stk.push(root);
		}
		
		while(result != null){
			
			TreeNode curr = stk.peek();
			
			if(curr.left == null && curr.right == null){
				
				result = stk.pop();
				TreeNode prev = stk.peek();
				if(prev.left == result){
					left = true;
				}
				if(prev.right == result)
					right = true;
				
				continue;
			}
			
			if(left && right){
				left = false;
				right = false;
				TreeNode t = stk.pop();
				TreeNode prev = stk.peek();
				if(prev == null)
					return;
				if(prev.left == t)
					left = true;
				if(prev.right == t)
					right = true;
			}
			
			if(!left && curr.left!= null){
				stk.push(curr.left);
				continue;
			}
			if(!right && curr.right != null){
				stk.push(curr.right);
				continue;
			}
		}
		
		
	}
	
	
	@Override
	public boolean hasNext() {
		
		if(root == null)
			return false;
		
		traverse();
		return result != null;
		
	}

	@Override
	public TreeNode next() {
		TreeNode res = result;
		result = null;
		return res;
	}
	

}
