package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1TreeBalanced {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Search Tree. 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}	

		
		//Build a Binary Search tree
		BinarySearchTree bst = new BinarySearchTree();
		
		for (Integer x : lst){
			bst.insertNode(bst.root, x);
		}
		
		
		Result r = new Result();
		r.isTreeBalanced = true;
		isTreeBalanced(bst.root, r);
		System.out.println(r.isTreeBalanced);
		
		sc.close();
		
	}
	
	private static int isTreeBalanced(Node root, Result r){
		
		if (root == null)
			return 0;
		
		int leftChilds = isTreeBalanced(root.left, r) +1;
		int rightChilds = isTreeBalanced(root.right, r) +1;
		
		if (r.isTreeBalanced){
			if(leftChilds == rightChilds || leftChilds == rightChilds +1 || rightChilds == leftChilds+1){
				r.isTreeBalanced = true & r.isTreeBalanced;
			}
			else{
				r.isTreeBalanced = false;
			}
		}
		
		return leftChilds > rightChilds ? leftChilds : rightChilds;
	}
	
	private static void isTreeBalanced2(Node root){
		
		
		
	}
	
}

class Result{
	
	boolean isTreeBalanced;
	
}