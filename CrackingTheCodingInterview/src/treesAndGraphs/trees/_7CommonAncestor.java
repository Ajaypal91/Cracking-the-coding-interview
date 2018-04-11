package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _7CommonAncestor {

	public static boolean v1, v2;
	static Node root;
	
	static class Result{
		
		Node node;
		boolean isAnc;
		public Result(Node n, boolean val){
			node = n;
			isAnc = val;
		}
		
	}
	
	public static void main(String[] args) {
		//create a BT
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Tree, -1 for null and 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		//build a level order binary tree
		BinaryTree bt = new BinaryTree();
		bt.insertNodeinLevelOrder(lst);
		
		List<Node> arr = new ArrayList<>();
		TreesOperation.getListNodes(bt.root, arr);
		
		//get two nodes
		System.out.println("Tell Index of first node");
		Node n1 = arr.get(sc.nextInt()-1);
		System.out.println("Node selected = "+n1.value);
		System.out.println("Tell Index of second node");
		Node n2 = arr.get(sc.nextInt()-1);
		System.out.println("Node selected = "+n2.value);
//		Node res = getCommonAncestor(bt.root, n1, n2);
		root = bt.root;
		Node res = findLCA(n1.value, n2.value);
		if(res == null)
			System.out.println("Null Value");
		else
			System.out.println(res.value);
		
		sc.close();
	}
	
	private static boolean doesBelongToSubtree(Node root, Node child){
		
		if (root == null)
			return false;
		if (root == child)
			return true;
		
		return doesBelongToSubtree(root.left, child) || doesBelongToSubtree(root.right, child);
	}
	
	private static Node getCommonAncestor(Node root, Node n1 , Node n2){
		
		//if nodes does not exist in subtree
		if (!doesBelongToSubtree(root, n1) || !doesBelongToSubtree(root, n2))
			return null;
		
		return commonAncestor(root, n1, n2);
		
	}
	
	private static Node commonAncestor(Node root, Node n1, Node n2){
		
		if (root == null)
			return null;
		
		boolean isn1OnLeft = doesBelongToSubtree(root.left, n1);
		boolean isn2OnLeft = doesBelongToSubtree(root.left, n2);
		
		if (isn1OnLeft != isn2OnLeft)
			return root;
		
		return isn1OnLeft && isn2OnLeft ? commonAncestor(root.left, n1, n2) : commonAncestor(root.right, n1, n2);
		
	}
	
	
	
	//OPTIMIZED O(n) solution from Cracking the coding interview
	public static Result findLCAUtil(Node root, int n1, int n2)
    {
        
		if(root == null)
			return new Result(null, false);
		
		if(root.value == n1 && root.value == n2)
			return new Result(root, true);
		
		Result left = findLCAUtil(root.left, n1, n2);
		if(left.isAnc)
			return left;
		Result right = findLCAUtil(root.right, n1, n2);
		if(right.isAnc)
			return right;
		
		if(left.node != null && right.node != null)
			return new Result(root, true);
		if(root.value == n1 || root.value == n2){
			boolean isAv = left.node != null || right.node != null ? true :false;
			return new Result(root, isAv);
		}
		else{
			return new Result(left.node != null ? left.node : right.node , false);
		}
	
    }
 
    // Find lca of n1 and n2 under the subtree rooted with 'node'
    public static Node findLCA(int n1, int n2)
    {
    	Result lca = findLCAUtil(root, n1, n2);
 
    	if(lca.isAnc)
    		return lca.node;
        
        return null;
    }

}

