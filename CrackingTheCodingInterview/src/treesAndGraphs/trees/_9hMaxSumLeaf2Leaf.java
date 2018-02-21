package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
public class _9hMaxSumLeaf2Leaf {

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
		TreesOperation.inorderTraversal(bt.root);
		
		
		maxPathSum(bt.root);
		System.out.println(maxSum);
		sc.close();
		
	}
	
	private static int maxPathSum(Node root) {
		
		if(root == null)
			return 0;
		
		int l = maxPathSum(root.left);
		int r = maxPathSum(root.right);
		
		if(root.left != null && root.right != null) {
			maxSum = Math.max(maxSum, l+r+root.value);
			
			return Math.max(l, r)+root.value;
		}
		
		if(root.left!=null)
			return l+root.value;
		else
			return r+root.value;
		
	}
	
}
