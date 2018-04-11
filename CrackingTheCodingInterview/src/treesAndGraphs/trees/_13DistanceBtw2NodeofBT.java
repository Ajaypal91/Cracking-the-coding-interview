package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import treesAndGraphs.trees._7CommonAncestor.Result;

/**
 * EXAMPLE input below
1
2
3
4
5
-1
-1
6
0
Tell Index of first node
2
Node selected = 2
Tell Index of second node
3
Node selected = 3
 * @author ajay
 *
 */
public class _13DistanceBtw2NodeofBT {

	static class Result{
		
		int distance;
		boolean isAnc;
		Node n;
		public Result(int d, boolean b, Node m){
			distance = d;
			isAnc = b;
			n = m;
		}
		
	}
	
	static class Result2{
		
		Node node;
		boolean isAnc;
		public Result2(Node n, boolean val){
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
		
		System.out.println(Method2(bt.root, n1.value, n2.value));
		

	}
	
	public static Result getDistanceMethod1(Node root, int n1, int n2){
		
		if(root == null)
			return new Result(0, false, null);
		
		Result left = getDistanceMethod1(root.left, n1, n2);
		if(left.isAnc)
			return left;
		
		Result right = getDistanceMethod1(root.right, n1, n2);
		if(right.isAnc)
			return right;
		
		if(left.n != null && right.n != null)
			return new Result(left.distance + right.distance+2, true, root);
		
		if(root.value == n1 || root.value == n2){
			boolean b = left.n != null || right.n != null ? true: false;
			int distance = 0;
			if(left.n != null)
				distance = 1 + left.distance;
			if(right.n != null)
				distance = 1 + right.distance;
			return new Result(distance, b, root);
		}
		else{
			int distance = 0;
			Node n = null;
			if(left.n != null){
				distance = left.distance +1;
				n = left.n;
			}
			if(right.n != null){
				distance = right.distance+1;
				n = right.n;
			}
			return new Result(distance, false, n);
		}
	}
	
	//get Distance using LCA approach but in same call
	public static int Method1(Node root, int n1, int n2){
		
		Result res = getDistanceMethod1(root, n1, n2);
		if(res.isAnc)
			return res.distance;
		return 0;
		
	}
	
	public static int findDistance(Node root, int n, int level){
		
		if(root == null)
			return -1;
		
		if(root.value == n)
			return level;
		
		int left = findDistance(root.left, n, level+1);
		if(left!=-1)
			return left;
		return findDistance(root.right, n, level+1);
		
		
	}
	
	//LCA Method
	//find LCA first then calculate the distance
	public static int Method2(Node root, int n1, int n2){
		
		Node lca = findLCA(root, n1, n2);
		if(lca == null)
			return 0;
		
		System.out.println("LCA is " + lca.value);
		int d1 = findDistance(lca, n1, 0);
		int d2 = findDistance(lca, n2, 0);
		
		System.out.println("Distance d1 = " + d1);
		System.out.println("Distance d2 = " + d2);
		return d1+d2;
		
	}
	
	//OPTIMIZED O(n) solution from Cracking the coding interview
		public static Result2 findLCAUtil(Node root, int n1, int n2)
	    {
	        
			if(root == null)
				return new Result2(null, false);
			
			if(root.value == n1 && root.value == n2)
				return new Result2(root, true);
			
			Result2 left = findLCAUtil(root.left, n1, n2);
			if(left.isAnc)
				return left;
			Result2 right = findLCAUtil(root.right, n1, n2);
			if(right.isAnc)
				return right;
			
			if(left.node != null && right.node != null)
				return new Result2(root, true);
			if(root.value == n1 || root.value == n2){
				boolean isAv = left.node != null || right.node != null ? true :false;
				return new Result2(root, isAv);
			}
			else{
				return new Result2(left.node != null ? left.node : right.node , false);
			}
		
	    }
	 
	    // Find lca of n1 and n2 under the subtree rooted with 'node'
	    public static Node findLCA(Node root, int n1, int n2)
	    {
	    	Result2 lca = findLCAUtil(root, n1, n2);
	 
	    	if(lca.isAnc)
	    		return lca.node;
	        
	        return null;
	    }
	
	

}
