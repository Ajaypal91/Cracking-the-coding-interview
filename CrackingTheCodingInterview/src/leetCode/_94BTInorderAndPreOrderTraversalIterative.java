package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94BTInorderAndPreOrderTraversalIterative {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		root.right = node1;
		node1.left = node2;
		node1.right = node3;
		
		System.out.println(inorderTraversal(root));
		System.out.println(preorderTraversal(root));
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        if(root != null){
            
        	TreeNode temp = root;
        	while(temp!=null){
        		stack.push(temp);
        		temp = temp.left;
        	}
            
            while(!stack.empty()){
                
                TreeNode curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
                
                //go left
                while(curr!=null){
                	stack.push(curr);
                    curr = curr.left;    
                }
                
            }
            
            
        }
        
        return result;
    }
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        if(root != null){
        	
        	TreeNode temp = new TreeNode(0);
        	temp.right = root;
        	stack.push(temp);
        	
        	while(!stack.empty()){
        		
        		TreeNode curr = stack.pop();
        		curr = curr.right;
        		
        		while(curr!=null){
        			
        			stack.push(curr);
        			result.add(curr.val);
        			curr = curr.left;
        			
        		}
        		
        	}
        	
        }
        
        
        
        return result;
    }
	

}
