package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	
public class _9gMaxPathSumBT {

	private static int maxSum;
	
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
		
		maxPathSum(bt.root);
		System.out.println(maxSum);
		sc.close();
		
	}
	
	private static int maxPathSum(Node root) {
		
		if(root == null)
			return 0;
		
		int leftSum = maxPathSum(root.left);
		int rightSum = maxPathSum(root.right);
		
		int maxPathChild = Math.max(Math.max(leftSum, rightSum)+root.value,root.value);
		
		int m = Math.max(maxPathChild, leftSum+rightSum+root.value);
		
		maxSum = Math.max(maxSum, m);
		
		return maxPathChild;
	}
	
	

}
