package leetCode;

/*
 * CHECK SOLUTION
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
 */

public class _114FlattenBTToLL {
	
//	 private static TreeNode prev = null;
	
	 // Definition for a binary tree node.
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 
	 public static void printLL(TreeNode root){
		 while(root!=null){
			 System.out.print(root.val + " ---> ");
			 root=root.right;
		 }
		 System.out.println();
	 }
	
	public static void main(String[] args) {
		
		TreeNode root =  new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		
		flatten2(root);
		printLL(root);
		
	}

	
	public static void flatten(TreeNode root) {
        
		if(root == null)
			return;
		
		flatten(root.left);
		flatten(root.right);
		
		//put left to right
		if(root.left != null){
			TreeNode temp = root.right;
			root.right = root.left;
			TreeNode curr = root.right;
			//traverse till end of right to find leaf
			while(curr.right!=null){
				curr = curr.right;
			}
			curr.right = temp;
			root.left = null;
		}
		
    }
	
	private static TreeNode flatten3(TreeNode root, TreeNode pre) {
	    if(root==null) return pre;
	    pre=flatten3(root.right,pre);    
	    pre=flatten3(root.left,pre);
	    root.right=pre;
	    root.left=null;
	    pre=root;
	    return pre;
	}
	
	public static void flatten2(TreeNode root) {
		flatten3(root,null);
	}
}
