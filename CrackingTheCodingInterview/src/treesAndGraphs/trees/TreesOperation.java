package treesAndGraphs.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreesOperation {
	
	public static void inorderTraversal(Node root){
		if (root == null){
			return;
		}
		
		inorderTraversal(root.left);
		System.out.println(root.value);
		inorderTraversal(root.right);
	}
	
	public static void preorderTraversal(Node root){
		if (root == null){
			return;
		}
		
		System.out.println(root.value);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		
	}
		
	public static void postorderTraversal(Node root){
		if (root == null){
			return;
		}
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.value);
	}
	
	//using a queue
	public static void levelOrderTraversal(Node root){
		
		Queue<Node> que = new LinkedList<>();
		
		if (root == null)
			return;
		
		que.add(root);
		
		while(!que.isEmpty()){
			
			Node n = que.poll();
			System.out.println(n.value);
			if(n.left != null)
				que.add(n.left);
			if(n.right != null)
				que.add(n.right);
		}
		
	}
	
	//using height or levels
	public static void levelOrderTraversalUsingLevels(Node root){
		
		int n = numberOfNodesTrees(root);
		System.out.println("Number of nodes = " + n);
		int levels = (int) (Math.log(n)/Math.log(2))+1;
		System.out.println("Number of levels = " + levels);
		for (int level = 1 ; level <= levels; level++){
			printLevel(root, level, 1);
		}
		
	}
	
	public static void printLevel(Node root, int level, int currLevel){
		
		if (root == null)
			return;
		
		if(level == currLevel){
			System.out.println(root.value);
			return;	
		}
		
		printLevel(root.left, level, currLevel+1);
		printLevel(root.right, level, currLevel+1);
		
	}
	
	public static int numberOfNodesTrees(Node root){
		
		if(root == null)
			return 0;
		
		return numberOfNodesTrees(root.left) + numberOfNodesTrees(root.right) + 1; 
		
	}
	
	
	
}
