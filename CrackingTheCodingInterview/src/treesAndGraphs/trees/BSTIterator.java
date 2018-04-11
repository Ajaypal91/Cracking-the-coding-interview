package treesAndGraphs.trees;

import java.util.Iterator;
import java.util.Stack;

//https://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
public class BSTIterator implements Iterator<Node>{

	Stack<Node> stk;
	
	public BSTIterator(Node root){
		
		stk = new Stack<>();
		
		while(root!=null){
			stk.push(root);
			root = root.left;
		}
		
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return stk.empty();
	}

	@Override
	public Node next() {
		// TODO Auto-generated method stub
		Node n = stk.pop();
		Node result = n;
		if(n!=null){
			n = n.right;
			while(n!=null){
				stk.push(n);
				n = n.left;
			}
		}
		return result;
	}

	
	
}
